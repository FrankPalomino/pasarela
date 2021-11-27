/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.pasarela.repositories;

import com.main.pasarela.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author frank
 */
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer>{
    
}
