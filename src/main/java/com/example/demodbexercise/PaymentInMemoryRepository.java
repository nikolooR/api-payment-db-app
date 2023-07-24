package com.example.demodbexercise;

import com.example.demodbexercise.domain.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PaymentInMemoryRepository {
    private List<Payment> payments;
    public PaymentInMemoryRepository(){
        payments = new ArrayList<>();
    }

    public void savePayment(Payment payment){
        payments.add(payment);
    }
    public List<Payment> listPayments(){
        return payments;
    }
}
