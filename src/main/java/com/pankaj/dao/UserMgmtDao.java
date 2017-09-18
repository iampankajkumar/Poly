package com.pankaj.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pankaj.dto.LoginStatus;
import com.pankaj.dto.UserMaster;
import com.pankaj.exception.CustomErrorCode;
import com.pankaj.exception.CustomErrorMessage;
import com.pankaj.exception.CustomException;
import com.pankaj.util.HibernateUtils;

public class UserMgmtDao {

	public short registerUser(UserMaster userMaster) throws Exception {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(userMaster);
		session.getTransaction().commit();
		session.beginTransaction();
		session.save(new LoginStatus(userMaster.getUserId(), userMaster.getUserName(), "Y"));
		session.getTransaction().commit();
		session.close();
		return userMaster.getUserId();
	}

	public void checkAvailability(String userName, String email, String phone) throws CustomException {
		Criteria criteria = null;
		Session session = null;
		try {
			session = HibernateUtils.getSessionFactory().openSession();
			Junction junc = Restrictions.disjunction().add(Restrictions.eq("userName", userName));
			if (phone != null)
				junc.add(Restrictions.eq("phone", phone));
			if (email != null)
				junc.add(Restrictions.eq("email", email));
			criteria = session.createCriteria(UserMaster.class)
					.setProjection(Projections.projectionList().add(Projections.property("userName"))
							.add(Projections.property("email")).add(Projections.property("phone")));
			criteria.add(junc);

			List<UserMaster[]> checkList = null;
			short[] bitArr = new short[3];
			checkList = criteria.list();
			if (checkList.size() > 0) {
				for (Object[] plr : checkList) {
					if (userName.equalsIgnoreCase((String) plr[0]))
						bitArr[0] = 1;
					if (email != null && email.equalsIgnoreCase((String) plr[1]))
						bitArr[1] = 1;
					if (phone != null && phone.equals(plr[2]))
						bitArr[2] = 1;
				}
				// converting binary sequence of bits to decimal number(Verdict
				// Index)
				int verdictIndex = Integer.parseInt("" + bitArr[0] + bitArr[1] + bitArr[2], 2);

				// adjusting it for the array index
				verdictIndex--;
				int errCodeArr[] = new int[] { // bin---> decimal

						CustomErrorCode.PLR_MOBILE_NO_EXIST, // 001--->1
						CustomErrorCode.PLR_EMAIL_EXIST, // 010--->2
						CustomErrorCode.PLR_EMAIL_MOBILE_EXIST, // 011--->3
						CustomErrorCode.PLR_USER_NAME_EXIST, // 100--->4
						CustomErrorCode.PLR_USER_NAME_MOBILE_EXIST, // 101--->5
						CustomErrorCode.PLR_USER_NAME_EMAIL_EXIST, // 110--->6
						CustomErrorCode.PLR_USER_NAME_EMAIL_MOBILE_EXIST }; // 111--->7

				String errMsgArr[] = new String[] { // bin---> decimal
						CustomErrorMessage.PLR_MOBILE_NO_EXIST, // 001--->1
						CustomErrorMessage.PLR_EMAIL_EXIST, // 010--->2
						CustomErrorMessage.PLR_EMAIL_MOBILE_EXIST, // 011--->3
						CustomErrorMessage.PLR_USER_NAME_EXIST, // 100--->4
						CustomErrorMessage.PLR_USER_NAME_MOBILE_EXIST, // 101--->5
						CustomErrorMessage.PLR_USER_NAME_EMAIL_EXIST, // 110--->6
						CustomErrorMessage.PLR_USER_NAME_EMAIL_MOBILE_EXIST }; // 111--->7

				throw new CustomException(errCodeArr[verdictIndex], errMsgArr[verdictIndex]);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new CustomException(CustomErrorCode.GEN_HIBERNATE_EXCEPTION,
					CustomErrorMessage.GEN_HIBERNATE_EXCEPTION);
		} catch (CustomException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(CustomErrorCode.GEN_SOME_INTERNAL_ERROR,
					CustomErrorMessage.GEN_SOME_INTERNAL_ERROR);
		} finally {
			session.close();
		}
	}

	public UserMaster userLogin(String userName, String password) throws CustomException {
		Session session = null;
		List<UserMaster> list = null;
		try {

			session = HibernateUtils.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(UserMaster.class);
			criteria.add(Restrictions.eq("userName", userName));
			criteria.add(Restrictions.eq("password", password));
			list = criteria.list();
			if (list.size() == 1) {
				session.beginTransaction();
				session.saveOrUpdate(new LoginStatus(list.get(0).getUserId(), userName, "Y"));
				session.getTransaction().commit();
			} else
				throw new CustomException(CustomErrorCode.INVALID_USERNAME_OR_PASSWORD,
						CustomErrorMessage.INVALID_USERNAME_OR_PASSWORD);
		} finally {
			session.close();
		}
		return list.get(0);
	}

	public void forgotPassword(String email) throws CustomException {
		Session session = null;
		List<UserMaster> list = null;
		try {

			session = HibernateUtils.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(UserMaster.class);
			criteria.add(Restrictions.eq("email", email));
			list = criteria.list();
			if (list.size() == 1) {
				// Send email to the particular address
			} else
				throw new CustomException(CustomErrorCode.INCORRECT_EMAIL, CustomErrorMessage.INCORRECT_EMAIL);
		} finally {
			session.close();
		}
	}

	public static void main(String[] args) {
		try {
			new UserMgmtDao().userLogin("pankaj", "8010215963");
		} catch (CustomException ex) {
			System.out.println(ex.getErrorCode() + "," + ex.getErrorMsg());
		}
	}

}
