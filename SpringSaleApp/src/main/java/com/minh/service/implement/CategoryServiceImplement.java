/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.service.implement;

import com.minh.pojo.Category;
import com.minh.repository.CategoryRepository;
import com.minh.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CategoryServiceImplement implements CategoryService{
    @Autowired
    private CategoryRepository cateRepo;   
    
    @Override
    public List<Category> getCates() {
        return this.cateRepo.getCates();
    }
    
}
