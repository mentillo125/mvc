package com.sds.dao;

import java.util.ArrayList;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;
public class SelectAllTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Service<String, CustomerVO>	service = 
		new CustomerService();
		
		ArrayList<CustomerVO> list = null;
		try {
			list = service.get();
			for(CustomerVO c:list) {
				System.out.println(c);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
