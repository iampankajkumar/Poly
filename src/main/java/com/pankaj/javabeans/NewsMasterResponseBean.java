package com.pankaj.javabeans;

import java.util.Date;

public class NewsMasterResponseBean {
	private short newsId;
	private short userId;
	private String heading;
	private String description;
	private String newsFileName;
	private String newsFile;
	private Date uploadDate;

	public NewsMasterResponseBean(short newsId, short userId, String heading, String description, String newsFileName,
			String newsFile, Date uploadDate) {
		this.newsId = newsId;
		this.userId = userId;
		this.heading = heading;
		this.description = description;
		this.newsFileName = newsFileName;
		this.newsFile = newsFile;
		this.uploadDate = uploadDate;
	}

	public short getNewsId() {
		return newsId;
	}

	public void setNewsId(short newsId) {
		this.newsId = newsId;
	}

	public short getUserId() {
		return userId;
	}

	public void setUserId(short userId) {
		this.userId = userId;
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

	public String getNewsFileName() {
		return newsFileName;
	}

	public void setNewsFileName(String newsFileName) {
		this.newsFileName = newsFileName;
	}

	public String getNewsFile() {
		return newsFile;
	}

	public void setNewsFile(String newsFile) {
		this.newsFile = newsFile;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

}
