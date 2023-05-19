package com.uuhnaut69.inventory.infrastructure.repository;

import jakarta.persistence.*;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "products")
public class ProductEntity {

  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  private int stocks;
}
