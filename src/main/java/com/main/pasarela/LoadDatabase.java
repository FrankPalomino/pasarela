package com.main.pasarela;

import com.main.pasarela.entities.PaymentType;
import com.main.pasarela.entities.ProductType;
import com.main.pasarela.repositories.PaymentTypeRepository;
import com.main.pasarela.repositories.ProductTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author frank
 */
@Configuration
public class LoadDatabase {
    
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    
    @Bean
    CommandLineRunner initDatabase(PaymentTypeRepository paymentTypeRepository){
        return args -> {
            log.info("Preloading " + paymentTypeRepository.save(new PaymentType(1,"VISA")));
            log.info("Preloading " + paymentTypeRepository.save(new PaymentType(2,"MASTERCARD")));
        };
    }
    
    @Bean
    CommandLineRunner initDatabase2(ProductTypeRepository productTypeRepository){
        return args -> {
            log.info("Preloading " + productTypeRepository.save(new ProductType(1,"LAPTOPS")));
            log.info("Preloading " + productTypeRepository.save(new ProductType(2,"PCS")));
            log.info("Preloading " + productTypeRepository.save(new ProductType(3,"PHONES")));
            log.info("Preloading " + productTypeRepository.save(new ProductType(4,"TABLETS")));
            log.info("Preloading " + productTypeRepository.save(new ProductType(5,"OTHER")));
        };
    }
}
