package com.example.demodbexercise.service;

import com.example.demodbexercise.PaymentRepository;
import com.example.demodbexercise.domain.Payment;
import com.example.demodbexercise.helperClasses.CsvHelper;
import com.example.demodbexercise.helperClasses.ParseDataToObjects;
import com.example.demodbexercise.helperClasses.PaymentInputForm;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class PaymentDataBaseService implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentDataBaseService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void addPayment(MultipartFile file) throws IOException {
        paymentRepository.saveAll(CsvHelper.csvToPayments(file.getInputStream()));
    }

    @Override
    public void addPayment(List<PaymentInputForm> request) {
        paymentRepository.saveAll(ParseDataToObjects.paymentList(request));
    }

    @Override
    public List<Payment> listPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public void deletePayment(UUID id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> searchByIban(String iban) {
        return paymentRepository.searchByIban(iban);
    }

    @Override
    public void deleteAllPayments() {
        paymentRepository.deleteAll();
    }


}
