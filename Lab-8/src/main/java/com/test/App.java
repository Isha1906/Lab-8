/*-- Project Made by Isha Vats --*/

/*--Create one to many relationship one Teacher and their Courses.
A teacher name Mrudula can give multiple courses likeJava Programming,
Python programming, Angular Programming but a course is given by only one teacher--*/

package com.test;

import java.util.List;          

import org.hibernate.Session;               //all necessary packages imported
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class App              //class app
{
    public static void main( String[] args )    //main() class
    {  
    	
    	/*-- Configuration for teacher and Course Entity --*/
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Teacher.class);
        
        Configuration cfg1=new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(Course.class);
        
        
        /*-- creating object of SessionFactory to use buildSessionFactory() method --*/
        SessionFactory sf=cfg.buildSessionFactory();
        
        /*- creating Session object to use openSession() method -*/
        Session ses=sf.openSession();
        
        /*- creating transaction object to use beginTransaction() method -*/
        Transaction tct=ses.beginTransaction();
        
        System.out.println("Session started ");
        
        Teacher t1=new Teacher();              //creating object for Teacher entity to store data
        t1.setTname("Roman Reigns");
        
        Course c=new Course();                 //creating Course entity object to store data
        c.setcName("Maths");
        
        Course c1=new Course();
        c1.setcName("Bio-Chemistry");
        
        Course c2=new Course();
        c2.setcName("c");
        
        
        /*-- adding all the data in crs list --*/
        t1.getCrs().add(c);                  
        t1.getCrs().add(c1);
        t1.getCrs().add(c2);
        ses.save(t1);            //saving data using session object
        
        
        /*-- Deleting from Teacher Entity where tId=2 --*/
        Teacher st1=(Teacher)ses.get(Teacher.class,2);
        ses.delete(st1);      
        ses.getTransaction();
        System.out.println(" deletion completed ");
        
        
        /*-- Updating Teacher entity where tId=3 --*/
        Teacher st=(Teacher)ses.get(Teacher.class,3);
        st.setTname("Mitali Kapoor");     
        ses.getTransaction();
        System.out.println("-- Updation Completed --");
        
        
        /*-- Showing the details from Teacher Entity using for-each loop --*/
        Query q=ses.createQuery("from Teacher");
        List<Teacher> s=q.list();
        System.out.println("---------Displaying data--------");
        for(Teacher t:s)
        {
        	System.out.println("Teacher Id: "+t.gettId()+"  Teacher Name: "+t.getTname());
        }
        
        
        /*-- Showing the details from Course Entity using for-each loop --*/
        Query q1=ses.createQuery("from Course");
        List<Course> s1=q1.list();
        System.out.println("\n---------Displaying data--------");
        for(Course cs:s1)
        {
        	System.out.println("Course Id: "+cs.getcId()+"  Course Name: "+cs.getcName());
        }
        
   
        tct.commit();            //permanently saving changes in the database using commit() method
        ses.close();             //closing session after work is finished using close() method
        
    }
}
