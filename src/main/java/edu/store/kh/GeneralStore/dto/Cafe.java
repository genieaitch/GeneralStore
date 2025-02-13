package edu.store.kh.GeneralStore.dto;

import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cafe {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private Time openingTime;
    private Time closingTime;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
