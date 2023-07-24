package com.example.demodbexercise.helperClasses;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInputForm {
    @CsvBindByPosition(position = 0)
    private BigDecimal amount;
    @CsvBindByPosition(position = 1)
    private String debtorIban;
}
