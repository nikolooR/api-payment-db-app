package com.example.demodbexercise.service;

import com.example.demodbexercise.domain.Payment;
import com.example.demodbexercise.helperClasses.PaymentInputForm;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
@Service
public interface PaymentService {

    void addPayment(MultipartFile file) throws IOException;
    void addPayment(List<PaymentInputForm> request);
    List<Payment> listPayments();

    void deletePayment(UUID id);

    List<Payment> searchByIban(String iban);

    void deleteAllPayments();

}
