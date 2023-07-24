package com.example.demodbexercise;

import com.example.demodbexercise.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Payment p WHERE p.id = :id")
    void deleteById(@Param("id") UUID id);

    @Query("SELECT p FROM Payment p WHERE p.debtorIban = :iban")
    List<Payment> searchByIban(@Param("iban") String iban);

}
