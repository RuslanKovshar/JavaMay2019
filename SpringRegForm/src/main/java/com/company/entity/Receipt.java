package com.company.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder

/*@Entity
@Table(name="receipt")*/
public class Receipt {

  /*  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)*/
   // private Long id;

    //@Column
    private Application application;

   // @Column
    private BigDecimal cost;
}
