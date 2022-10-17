package com.example.test.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class Rank_8 {

        @Id
        private Integer id;
        private String coun;
        private String num;
        private String time;

}
