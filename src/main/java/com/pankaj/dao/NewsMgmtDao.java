package com.pankaj.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.pankaj.dto.NewsMaster;
import com.pankaj.exception.CustomException;
import com.pankaj.util.HibernateUtils;

public class NewsMgmtDao {

	public void uploadNews(NewsMaster newsMaster) throws CustomException {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(newsMaster);
		session.getTransaction().commit();
	}

	public List<NewsMaster> getAllNewsList() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Criteria criteria=session.createCriteria(NewsMaster.class);
		criteria.add(Restrictions.lt("uploadDate",new Date()));
		List<NewsMaster> list=criteria.list();
		return list;
	}

}
