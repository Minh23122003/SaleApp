/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;


import com.minh.pojo.Category;
import com.minh.repository.CategoryRepository;
import javax.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *s
 * @author PC
 */
@Repository
@Transactional
public class CategoryRepositoryImplement implements CategoryRepository{
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Category> getCates() {
            Session s = this.factory.getObject().getCurrentSession();
            Query q = s.createQuery("From Category");
            
            return q.getResultList();
    }
}
