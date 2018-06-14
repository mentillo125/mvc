package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class ItemDao extends Dao<String, ItemVO> {

	@Override
	public void insert(ItemVO v, Connection con) throws Exception {
		// TODO Auto-generated method stub
	
		PreparedStatement pstmt = null;
			try {
				pstmt = con.prepareStatement(SQL.insertItem);
				pstmt.setString(1,  v.getId());
				pstmt.setString(2,  v.getName());
				pstmt.setDouble(3,  v.getPrice());
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
	public void update(ItemVO v, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemVO select(String t, Connection con) throws Exception {
		// TODO Auto-generated method stub

			PreparedStatement pstmt = null;
			ItemVO item = null;
			ResultSet rset = null;
			try {
				pstmt = con.prepareStatement(SQL.getCustomerItem);
				pstmt.setString(1,  t);
				rset = pstmt.executeQuery();
				rset.next();
				item = new ItemVO (
						rset.getString("ID"),
						rset.getString("NAME"),
						rset.getDouble("PRICE")
						);
			}catch(Exception e) {
				throw e;
			}finally {
				close(pstmt);
				close(rset);
			}
		return item;
		}

	

	@Override
	public ArrayList<ItemVO> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
