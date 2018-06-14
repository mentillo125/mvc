package com.sds.app;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class App {

	public static void main(String[] args) {
		Service<String, CustomerVO> service = new CustomerService(); 
		CustomerVO customer = new CustomerVO("id02","pwd02","�踻��");
		try {
			service.register(customer);
			System.out.println("�Է� ����");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�Է� ����");
		}
	}

}
