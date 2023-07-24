package com.example.demodbexercise.helperClasses;

import com.example.demodbexercise.domain.Payment;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvHelper {

    public static Logger logger = LoggerFactory.getLogger(CsvHelper.class);
    private static final String TYPE = "text/csv";
    private static final String[] COLUMN_NAMES = {"amount", "debtorIban"};

    public static boolean verifyFile(MultipartFile file){
        return TYPE.equals(file.getContentType()) && !file.isEmpty();
    }

    public static List<Payment> csvToPayments(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));


        CsvToBean<PaymentInputForm> csvToBean = new CsvToBeanBuilder<PaymentInputForm>(reader)
                .withType(PaymentInputForm.class)
                .withSkipLines(1)
                .withSeparator(',')
                .build();

        List<PaymentInputForm> paymentFromCsvList = csvToBean.parse();
        return ParseDataToObjects.paymentList(paymentFromCsvList);
    }
}
