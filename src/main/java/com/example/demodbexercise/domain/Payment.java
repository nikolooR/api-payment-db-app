package com.example.demodbexercise.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payment_id")
    private UUID id;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "debtor_iban")
    private String debtorIban;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Payment(){}

    public Payment(BigDecimal amount, String debtorIban) {
        this.amount = amount;
        this.debtorIban = debtorIban;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDebtorIban() {
        return debtorIban;
    }

    public void setDebtorIban(String iban) {
        this.debtorIban = iban;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", debtorIban='" + debtorIban + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
