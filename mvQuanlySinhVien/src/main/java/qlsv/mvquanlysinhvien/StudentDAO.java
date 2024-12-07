/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlsv.mvquanlysinhvien;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
    private SessionFactory sessionFactory;
    
    public StudentDAO(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    // Create
    public void createStudent(String name, int age){
        // Mo Phien giao dich
        Session session =  sessionFactory.openSession();
        // Bat dau phien
        Transaction transaction = session.beginTransaction();
        Student student = new Student (name, age);
        session.save(student);
        transaction.commit();
        // Dong phien
        session.close();
    }
    
    // Read
    public Student readStudent(Long id){
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }
    
    // Update 
    public void updateStudent(Long id, String newName, int newAge){
        Session session = sessionFactory.openSession();
        // Bat dau phien
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if(student != null){
            student.setName(newName);
            student.setAge(newAge);
            session.update(student);
        }
        transaction.commit();
        session.close();
    }
    
    // Delete
    public void deleteStudent(Long id){
        Session session = sessionFactory.openSession();
        // Bat dau phien
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        if(student != null){
            session.delete(student);
        }
        transaction.commit();
        session.close();
    }
    
    // Close SessionFactory
    public void close(){
        sessionFactory.close();
    }
    
}
