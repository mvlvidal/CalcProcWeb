package br.com.mvlvidal.calcprocweb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    
    private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    
    public static Session getSession(){
    
        Session session = threadLocal.get();
        
        
        if(session == null){
        
            session = sessionFactory.openSession();
            threadLocal.set(session);
            
        }
        
        return session;
    }
    
}