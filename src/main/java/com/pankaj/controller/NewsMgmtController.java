package com.pankaj.controller;

import java.util.List;

import com.pankaj.dao.NewsMgmtDao;
import com.pankaj.dto.NewsMaster;
import com.pankaj.exception.CustomException;

public class NewsMgmtController {

	public void uploadNews(NewsMaster newsMaster) throws CustomException {
		new NewsMgmtDao().uploadNews(newsMaster);
	}

	public List<NewsMaster> getAllNewsList() {
		// TODO Auto-generated method stub
		return new NewsMgmtDao().getAllNewsList();
	}

}
