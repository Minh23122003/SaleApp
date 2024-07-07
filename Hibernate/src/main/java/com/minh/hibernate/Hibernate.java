/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.minh.hibernate;

import com.minh.pojo.Cart;
import com.minh.repository.implement.CategoryRepositoryImplement;
import com.minh.repository.implement.ReceiptRepositoryImplement;
import com.minh.repository.implement.StatsRepositoryImplement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PC
 */
public class Hibernate {

    public static void main(String[] args) {
        List<Cart> carts = new ArrayList<>();
        carts.add(new Cart(1, "iPhone 7", 2, 200l));
        
        ReceiptRepositoryImplement r = new ReceiptRepositoryImplement();
        r.addReceipt(carts);
    }
}
