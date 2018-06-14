package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerDao extends Dao<String, CustomerVO> {

	@Override
	public void insert(CustomerVO v, Connection con) throws Exception {
		// Connection을 통해 PreparedStatement 생성
		// SQL 작성 하여 DB 전송
		// Resource Close
		PreparedStatement pstmt = null;
		try {
		pstmt = con.prepareStatement(SQL.insertCustomer);
		pstmt.setString(1,  v.getId());
		pstmt.setString(2,  v.getPwd());
		pstmt.setString(3,  v.getName());
		pstmt.executeUpdate();
	
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
}

	@Override
	public void delete(String t, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CustomerVO v, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerVO select(String t, Connection con) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		CustomerVO customer = null;
		ResultSet rset = null;
		try {
			pstmt = con.prepareStatement(SQL.getCustomer);
			pstmt.setString(1,  t);
			rset = pstmt.executeQuery();
			rset.next();
			customer = new CustomerVO(
					rset.getString("ID"),
					rset.getString("PWD"),
					rset.getString("NAME")
					);
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(rset);
		}
	return customer;
	}

	@Override
	public ArrayList<CustomerVO> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
			PreparedStatement pstmt = null;
			ArrayList<CustomerVO> customers = new ArrayList<>();
			ResultSet rset = null;
			try {
				pstmt = con.prepareStatement(SQL.getCustomer);
				rset = pstmt.executeQuery();
				while(rset.next()) {
					CustomerVO customer = null;
					customer = new CustomerVO(rset.getString("ID"),
							rset.getString("PWD"),
							rset.getString("NAME"));
					customer.setItem(new ItemVO(
							rset.getString("ID"),
							rset.getString("IEMNAME"),
							rset.getDouble("PRICE")
							));
						customers.add(customer);
					
				}
			}catch(Exception e) {
				throw e;
			}finally {
				close(pstmt);
				close(rset);
			}
		return customers;
		
	}

}
