package com.pankaj.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.pankaj.controller.NewsMgmtController;
import com.pankaj.dto.NewsMaster;
import com.pankaj.javabeans.NewsMasterResponseBean;
import com.pankaj.util.Utility;

public class NewsMgmtAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file;
	private String fileContentType;
	private String fileFileName;
	private String heading;
	private String description;
	private String responseFileString;
	private short userId;
	private List<NewsMaster> newsList;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public String uploadNews() {

		// save image into database
		byte[] bFile = new byte[(int) file.length()];
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			// convert file into array of bytes
			fileInputStream.read(bFile);
			System.out.println(fileContentType);
			fileInputStream.close();

			NewsMaster newsMaster = new NewsMaster();
			newsMaster.setUserId(userId);
			newsMaster.setHeading(heading);
			newsMaster.setDescription(description);
			newsMaster.setNewsFileName(fileFileName);
			newsMaster.setNewsFileContentType(fileContentType);
			newsMaster.setNewsFile(bFile);
			newsMaster.setUploadDate(new Date());
			new NewsMgmtController().uploadNews(newsMaster);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void getAllNewsList() {
		NewsMgmtController controller = new NewsMgmtController();
		List<NewsMasterResponseBean> newsResponse = new ArrayList<NewsMasterResponseBean>();
		try {
			List<NewsMaster> newsList = controller.getAllNewsList();
			for (NewsMaster nm : newsList) {
				newsResponse.add(new NewsMasterResponseBean(nm.getNewsId(), nm.getUserId(), nm.getHeading(),
						nm.getDescription(), nm.getNewsFileName(),
						Utility.byteStreamToFile(nm.getNewsFile(), nm.getNewsFileContentType()), nm.getUploadDate()));
			}
			if (newsResponse.size() > 0) {
				response.getWriter().write(new Utility().convertJSON(newsResponse));
			} else
				response.getWriter().write("{}");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception be) {
			be.printStackTrace();
		}
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getResponseFileString() {
		return responseFileString;
	}

	public void setResponseFileString(String responseFileString) {
		this.responseFileString = responseFileString;
	}

	public short getUserId() {
		return userId;
	}

	public void setUserId(short userId) {
		this.userId = userId;
	}

	public List<NewsMaster> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsMaster> newsList) {
		this.newsList = newsList;

	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	public HttpServletResponse getServletResponse() {
		return response;
	}
}