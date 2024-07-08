/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.controllers;

//import com.minh.repository.implement.CategoryRepositoryImplement;
import com.minh.service.CategoryService;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author admin
 */
@Controller

public class HomeController {
    @Autowired
    private CategoryService cateService;
    
    @RequestMapping("/")
    
    public String index(Model model){
        model.addAttribute("categories", cateService.getCates());
        
        return "index";
    }
}