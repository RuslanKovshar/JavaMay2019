package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "applications")
public class Application {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "weight")
    private Double weight;

    @Enumerated(EnumType.STRING)
    private Types type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    @Column(name = "address")
    private String deliveryAddress;

    @JsonIgnore
    @OneToOne(mappedBy = "application")
    private Receipt application;
}
