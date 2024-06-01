package com.itotdel.money.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddTransactionRequest {
    private String userId;
    private Integer sum;
    private String category;
    private Date date;
}
