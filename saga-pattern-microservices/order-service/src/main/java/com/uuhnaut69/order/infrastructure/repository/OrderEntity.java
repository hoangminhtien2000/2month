package com.uuhnaut69.order.infrastructure.repository;

import com.uuhnaut69.order.domain.entity.OrderStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class OrderEntity {

  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long customerId;

  @Column(nullable = false)
  private Long productId;

  private BigDecimal price;

  private int quantity;

  private Timestamp createdAt;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private OrderStatus status;
}
