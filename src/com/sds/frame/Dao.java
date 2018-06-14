package com.sds.frame;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
public abstract class Dao {
	public abstract void insert() throws Exception;
	public abstract void delete() throws Exception;
	public abstract void update() throws Exception;
	public abstract Object select(Object obj) throws Exception;
	public abstract ArrayList<Object> select() throws Exception;
		
}
*/

public abstract class Dao<T,V> {

	public void close(ResultSet rset) throws SQLException {
		if(rset != null) {
			rset.close();
		}
	}
	
	public void close(PreparedStatement pstmt) throws SQLException {
		if(pstmt != null) {
			pstmt.close();
		}
	}
	
	public abstract void insert(V v, Connection con) throws Exception;
	public abstract void delete(T t, Connection con) throws Exception;
	public abstract void update(V v, Connection con) throws Exception;
	public abstract V select(T t, Connection con) throws Exception;
	public abstract ArrayList<V> select(Connection con) throws Exception;
	
}

