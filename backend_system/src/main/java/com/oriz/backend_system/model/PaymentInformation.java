package com.oriz.backend_system.model;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;


public class PaymentInformation {
    @Column(name = "cardholder_name")
    private String cardholderName;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "cvv")
    private String cvv;

}
