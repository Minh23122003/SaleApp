/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.hibernate.HibernateUtils;
import com.minh.pojo.User;
import jakarta.persistence.Query;
import org.hibernate.Session;
/**
 *
 * @author PC
 */
public class UserRepositoryImplement{
    public User getUserById(String username) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            Query q = s.createQuery("From User Where username=:username", User.class);
            q.setParameter("username", username);
            
            return (User) q.getSingleResult();
        }
    } 
}
