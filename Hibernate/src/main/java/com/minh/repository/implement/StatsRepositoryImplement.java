/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.minh.repository.implement;

import com.minh.hibernate.HibernateUtils;
import com.minh.pojo.OrderDetail;
import com.minh.pojo.Product;
import com.minh.pojo.SaleOrder;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import org.hibernate.Session;
/**
 *
 * @author PC
 */
public class StatsRepositoryImplement {
    public List<Object[]> statsRevenueByProduct() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            
            Root rP = q.from(Product.class);
            Root rD = q.from(OrderDetail.class);
            
            q.where(b.equal(rP.get("id"), rD.get("productId").as(Integer.class)));
            q.multiselect(rP.get("id"), rP.get("name"), 
                    b.sum(b.prod(rD.get("unitPrice"), rD.get("quantity"))));
            q.groupBy(rP.get("id"));
            
            Query query = s.createQuery(q);
            
            return query.getResultList();
        }
    }
    
    public List<Object[]> statsRevenueByProduct(int year, String peroid) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            
            Root rO = q.from(SaleOrder.class);
            Root rD = q.from(OrderDetail.class);
            
            q.where(b.equal(rO.get("id"), rD.get("orderId").as(Integer.class)),
                    b.equal(b.function("YEAR", Integer.class, rO.get("createdDate")), year));
            q.multiselect(b.function(peroid, Integer.class, rO.get("createdDate")), 
                    b.sum(b.prod(rD.get("unitPrice"), rD.get("quantity"))));
            q.groupBy(b.function(peroid, Integer.class, rO.get("createdDate")));
            
            Query query = s.createQuery(q);
            
            return query.getResultList();
        }
    }
}
