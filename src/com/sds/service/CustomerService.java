package com.sds.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.sds.dao.CustomerDao;
import com.sds.dao.ItemDao;
import com.sds.frame.Dao;
import com.sds.frame.Service;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerService extends Service<String, CustomerVO> {

	Dao<String, CustomerVO> cDao;
	Dao<String, ItemVO> iDao;
	
	public CustomerService() {
		cDao = new CustomerDao();
		iDao = new ItemDao();
	}
	
	@Override
	public void register(CustomerVO v) throws Exception {
		// 고객 정보가 들어오면
		// 고객 정보에 아이템을 셋팅 하고
		// Dao를 통해 저장 요청을 한다.
		ItemVO item = new ItemVO(v.getId(),"칼",1000);
		Connection con = getConn();
		try {
			cDao.insert(v,con);
			iDao.insert(item,con);
			con.commit();
			close(con);
		} catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public CustomerVO get(String t) throws Exception {
		// TODO Auto-generated method stub
		CustomerVO customer = null;
		Connection con = getConn();
		try {
			customer = cDao.select(t, con);
			customer.setItem(iDao.select(t, con));
		} catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return null;
		
	}

	@Override
	public void modify(CustomerVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public ArrayList<CustomerVO> get() throws Exception {
		// TODO Auto-generated method stub
		
		ArrayList<CustomerVO> customers = null;
		Connection con = getConn();
		try {
			customers = cDao.select(con);
			
		} catch (Exception e) {
			throw e;
		}
		finally {
			close(con);
		}
		return customers;
	}

	@Override
	public void remove(String t) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
