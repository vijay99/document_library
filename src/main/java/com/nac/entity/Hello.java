package com.nac.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hello")
public class Hello {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hello_id", nullable = false)
    private long id;
    @Column(name = "message")
    private String message;
}
