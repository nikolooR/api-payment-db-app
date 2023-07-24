package com.example.demodbexercise.service;

import com.example.demodbexercise.PaymentInMemoryRepository;
import com.example.demodbexercise.domain.Payment;
import com.example.demodbexercise.helperClasses.PaymentInputForm;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public class PaymentInMemoryService implements PaymentService{

    private PaymentInMemoryRepository paymentInMemoryRepository;
    public PaymentInMemoryService(PaymentInMemoryRepository paymentInMemoryRepository){
        this.paymentInMemoryRepository = paymentInMemoryRepository;
    }

    @Override
    public void addPayment(MultipartFile file) {
        //todo-impl
    }

    @Override
    public void addPayment(List<PaymentInputForm> request) {
        //todo-impl
    }

    @Override
    public List<Payment> listPayments() {
        //todo-impl
        return null;
    }

    @Override
    public void deletePayment(UUID id) {
        //todo-impl
    }

    @Override
    public List<Payment> searchByIban(String iban) {
        //todo-impl
        return null;
    }

    @Override
    public void deleteAllPayments() {
        //todo-impl
    }
}
