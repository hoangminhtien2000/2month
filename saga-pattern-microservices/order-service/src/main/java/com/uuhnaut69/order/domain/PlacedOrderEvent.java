package com.uuhnaut69.order.domain;

import java.math.BigDecimal;
import java.util.UUID;


public record PlacedOrderEvent(Long id, Long customerId, Long productId, BigDecimal price,
                               Integer quantity) {

}
