package com.example.demodbexercise;

import com.example.demodbexercise.domain.Payment;
import com.example.demodbexercise.helperClasses.CsvHelper;
import com.example.demodbexercise.helperClasses.PaymentInputForm;
import com.example.demodbexercise.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PaymentController {
    Logger logger = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/payment-files")
    public void savePayments(@RequestParam("file") MultipartFile file) throws IOException {
        if (CsvHelper.verifyFile(file)) {
            paymentService.addPayment(file);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "file is missing or incorrect");
        }
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/payments")
    public void savePayments(@RequestBody List<PaymentInputForm> request){
            paymentService.addPayment(request);
    }



    @ExceptionHandler({NullPointerException.class, IOException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleNullPointerException(Exception ex) {
        logger.error(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/payments")
    public List<Payment> searchByIban(@RequestParam("iban") Optional<String> iban) {
        if(iban.isPresent()){
            return paymentService.searchByIban(iban.get());
        }
        return paymentService.listPayments();
    }

    @DeleteMapping("/payment-delete")
    public void deletePayment(@RequestParam("id") UUID id) {
        paymentService.deletePayment(id);
    }


    @Value("${admin.delete.password}")
    String localPassword;

    @DeleteMapping("/payments-delete-all")
    public void deleteAll(@RequestParam("password") String password) {

        if (localPassword.equals(password)) {
            paymentService.deleteAllPayments();
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }

}
