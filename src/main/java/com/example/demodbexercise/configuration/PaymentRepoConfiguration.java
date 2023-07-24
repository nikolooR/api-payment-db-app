package com.example.demodbexercise.configuration;

import com.example.demodbexercise.PaymentInMemoryRepository;
import com.example.demodbexercise.PaymentRepository;
import com.example.demodbexercise.service.PaymentDataBaseService;
import com.example.demodbexercise.service.PaymentInMemoryService;
import com.example.demodbexercise.service.PaymentService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentRepoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "payment",name = "service.version", havingValue = "database")
    public PaymentService getDataBaseVersion(PaymentRepository paymentRepository){
        return new PaymentDataBaseService(paymentRepository);
    }

    @Bean
    @ConditionalOnProperty(prefix = "payment", name = "service.version", havingValue = "in-memory")
    public PaymentService getInMemoryVersionI(PaymentInMemoryRepository paymentInMemoryRepository){
        return new PaymentInMemoryService(paymentInMemoryRepository);
    }
}
