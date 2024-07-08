///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.minh.repository.implement;
//
//import com.minh.hibernate.HibernateUtils;
//import com.minh.pojo.Cart;
//import com.minh.pojo.OrderDetail;
//import com.minh.pojo.SaleOrder;
//import java.util.Date;
//import java.util.List;
//import org.hibernate.Session;
///**
// *
// * @author PC
// */
//public class ReceiptRepositoryImplement {
//    private UserRepositoryImplement u = new UserRepositoryImplement();
//    private ProductRepositoryImplement p = new ProductRepositoryImplement();
//    
//    public void addReceipt(List<Cart> carts) {
//        try (Session s = HibernateUtils.getFactory().openSession()) {
//            s.getTransaction().begin();
//            SaleOrder receipt = new SaleOrder();
//            receipt.setUserId(u.getUserById("dhthanh"));
//            receipt.setCreatedDate(new Date());
//            s.merge(receipt);
//            
//            for (var c: carts) {
//                OrderDetail d = new OrderDetail();
//                d.setQuantity(c.getQuantity());
//                d.setUnitPrice(c.getUnitPrice());
//                d.setOrderId(receipt);
//                d.setProductId(p.getProductId(c.getId()));
//                
//                s.merge(d);
//            }
//            s.getTransaction().commit();
//        }
//    }
//}
