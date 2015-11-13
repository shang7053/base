package com.liyi.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
		 private static SessionFactory sessionFactory;  
		    
		 /** 
		 * @return 获取会话工厂 
		 */  
		  public static SessionFactory getSessionFactory(){  
		    //第一步:读取Hibernate的配置文件  hibernamte.cfg.xml文件  
		    Configuration con=new Configuration().configure(); 
		    //创建注册服务  
		    ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).build();  
		    //第三步:创建会话工厂  
		    SessionFactory sessionFactory=con.buildSessionFactory(reg);  
		    return sessionFactory;  
		  }  
		    
		 /** 
		 * @return 获取会话对象 
		 */  
		  public static Session getSession(){  
		     return getSessionFactory().openSession();  
		  }  
}
