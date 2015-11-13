package com.liyi.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liyi.domain.TCustomer;
import com.liyi.util.HibernateUtil;

@Controller
@RequestMapping("/test")
public class Test {
	
  
	
	@SuppressWarnings("deprecation")
	@RequestMapping("/testhh")
	public String go(){
        Session session = HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction(); 
		TCustomer customer=new TCustomer("sss", "sss", 1);
		session.save(customer);
		transaction.commit();
		session.close();
//		TCustomer customer = (TCustomer)session.load(TCustomer.class, 201401);  
//	    System.out.println(customer.getCustomerName());
		return "index";
	}
}
