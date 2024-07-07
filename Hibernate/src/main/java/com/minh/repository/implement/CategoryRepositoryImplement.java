/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.hibernate.HibernateUtils;
import com.minh.pojo.Category;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author PC
 */
public class CategoryRepositoryImplement {
    public List<Category> getCates() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
//            Query q = s.createQuery("From Category", Category.class);
            Query q = s.createNamedQuery("Category.findAll", Category.class);
            
            return q.getResultList();
        }
    }
}
