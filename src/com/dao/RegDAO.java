package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vo.RegVO;
import com.vo.RegfVO;
import com.vo.loginVO;


@Repository
public class RegDAO
	{
		@Autowired 
		SessionFactory sessionFactory;
		
		public void insert(RegVO regVO)
			{
				try
					{
						 Session session=sessionFactory.openSession();
						 Transaction transaction=session.beginTransaction();
						 session.save(regVO);
						 transaction.commit();
						 session.close();
					}
				catch(Exception ex)
					{
						ex.printStackTrace();
					} 
			}
		
		public List search(RegVO regVO)
		{
			List ls=new ArrayList();	
	            
					//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
					
					Session session=sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					Query q=session.createQuery("from RegVO");
					
					ls=q.list();
				
					session.close();
					
			         return ls;
		
		}


     public List edit(RegVO regVO)
 {
	
    	 List ls=new ArrayList();
			//SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
			
			Session session=sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
		
			Query q=session.createQuery("from RegVO where id like '"+regVO.getId()+"'");
			
		    ls=q.list();
		    
		    transaction.commit();
		    
		    session.close();
			
		    return ls;
			
	         

    }



public void update(RegVO regVO)
{
	try
		{
			 Session session=sessionFactory.openSession();
			 Transaction transaction=session.beginTransaction();
			 session.saveOrUpdate(regVO);
			 transaction.commit();
			 session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		} 
}

	 

   public void delete(RegVO regVO)
   {
	   try
		{
			 Session session=sessionFactory.openSession();
			 Transaction transaction=session.beginTransaction();
			 session.delete(regVO);
			 transaction.commit();
			 session.close();
		}
	catch(Exception ex)
		{
			ex.printStackTrace();
		} 
}
   
   public void insertlvalue(loginVO vo)
	{
		try
			{
				 Session session=sessionFactory.openSession();
				 Transaction transaction=session.beginTransaction();
				 session.save(vo);
				 transaction.commit();
				 session.close();
			}
		catch(Exception ex)
			{
				ex.printStackTrace();
			} 
	}

   public void insertvalue(RegfVO regvo)
  	{
  		try
  			{
  				 Session session=sessionFactory.openSession();
  				 Transaction transaction=session.beginTransaction();
  				 session.save(regvo);
  				 transaction.commit();
  				 session.close();


  			}
  		catch(Exception ex)
  			{
  				ex.printStackTrace();
  			} 
  	}
   
   
	} 
   
   

