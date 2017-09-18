package com.pankaj.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news_master")
public class NewsMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private short newsId;

	@Column(name = "user_id")
	private short userId;

	private String heading;

	private String description;

	@Column(name = "news_name")
	private String newsFileName;

	@Column(name = "content_type")
	private String newsFileContentType;

	@Column(name = "file_stream")
	private byte[] newsFile;

	@Column(name = "uplaod_date")
	private Date uploadDate;

	public short getNewsId() {
		return newsId;
	}

	public void setNewsId(short newsId) {
		this.newsId = newsId;
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

	public short getUserId() {
		return userId;
	}

	public void setUserId(short userId) {
		this.userId = userId;
	}

	public String getNewsFileName() {
		return newsFileName;
	}

	public void setNewsFileName(String newsFileName) {
		this.newsFileName = newsFileName;
	}

	public byte[] getNewsFile() {
		return newsFile;
	}

	public void setNewsFile(byte[] newsFile) {
		this.newsFile = newsFile;
	}

	public String getNewsFileContentType() {
		return newsFileContentType;
	}

	public void setNewsFileContentType(String newsFileContentType) {
		this.newsFileContentType = newsFileContentType;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

}
