package com.uuhnaut69.order.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

public record OrderRequest(@NotNull Long customerId,
                           @NotNull Long productId,
                           @Min(1) @NotNull Integer quantity,
                           BigDecimal price) {

}
