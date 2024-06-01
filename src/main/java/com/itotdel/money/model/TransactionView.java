package com.itotdel.money.model;

import java.sql.Date;

public interface TransactionView {
    Integer getSum();
    String getCategory();
    Date getDate();
}
