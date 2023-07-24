package com.example.demodbexercise.helperClasses;

import com.example.demodbexercise.domain.Payment;
import org.iban4j.Iban4jException;
import org.iban4j.IbanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParseDataToObjects {
    static Logger logger = LoggerFactory.getLogger(ParseDataToObjects.class);
    public static List<Payment> paymentList(List<PaymentInputForm> payment){
        List<Payment> paymentList = new ArrayList<>();

        payment.forEach((p) -> {
            String trimmedIban = p.getDebtorIban().trim();
            try {
                if(p.getAmount().compareTo(BigDecimal.ZERO) < 0){
                    logger.warn("can add only positive amounts");
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                }
                IbanUtil.validate(trimmedIban);
                Payment newPayment = new Payment(p.getAmount(), trimmedIban);
                newPayment.setCreatedAt(LocalDateTime.now());
                paymentList.add(newPayment);
            } catch (Iban4jException ib){
                logger.error(ib.getMessage() + " iban: " + trimmedIban);
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        });
        return paymentList;
    }
}
