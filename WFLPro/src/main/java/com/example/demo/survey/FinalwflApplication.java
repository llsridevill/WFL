package com.example.demo.survey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalwflApplication {

	public static void main(String[] args){
		
		UserEntity ue=new UserEntity();
		UserResponseEntity ure=new UserResponseEntity();
		
		//ue.getUr().add(ure);
		//ure.getUser().add(ue);
		Configuration config=new Configuration().configure().addAnnotatedClass(UserEntity.class).addAnnotatedClass(UserResponseEntity.class);
		ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf=config.buildSessionFactory(registry);
		Session session=sf.openSession();
		Transaction tx = null;
		try{
			tx=session.beginTransaction();
			session.save(ure);
			session.save(ue);
			tx.commit();	
		}
		catch (Exception e) {
		    if (tx!=null) tx.rollback();
		    throw e;
		}
		finally{
			session.close();
			sf.close();
		}
		
		SpringApplication.run(FinalwflApplication.class, args);
	}

}



