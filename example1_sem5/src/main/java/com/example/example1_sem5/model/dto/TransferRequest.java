package com.example.example1_sem5.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private long senderAccountId;
    private  long receiverAccountId;
    private BigDecimal amount;
}
