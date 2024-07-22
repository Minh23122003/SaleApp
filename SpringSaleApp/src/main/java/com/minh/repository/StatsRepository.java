/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.minh.repository;

import java.util.List;

/**
 *
 * @author admin
 */
public interface StatsRepository {
    public List<Object[]> statsRevenueByProduct();
    public List<Object[]> statsRevenueByProduct(int year, String peroid);
}
