package com.itotdel.money.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Table(name = "task", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
    @Id
    private Integer id;
    private String taskName;
    private String description;
    private Date publicationDate;
}
