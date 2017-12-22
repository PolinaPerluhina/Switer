/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rest.switer.dao;

import com.rest.switer.dao.hiber.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Palina_Piarlukhina
 */
public class DAO {   
    
    private Session s;

    public DAO() {
        s = HibernateUtil.getSessionFactory().openSession();
    }
    
    public Session getSession(){
        if (!s.isOpen() | s == null){
            s = HibernateUtil.getSessionFactory().openSession();
        } else {
        }
        return s;
    }
    
    public void start(){    
        if (!s.isOpen() | s == null){
          s = HibernateUtil.getSessionFactory().openSession();
        }        
        s.beginTransaction();
    }

    public void commit(){
        s.getTransaction().commit();
    }
    
    public void close(){        
        s.close();
    }
   
    
    
     
    
    
    

   
}
