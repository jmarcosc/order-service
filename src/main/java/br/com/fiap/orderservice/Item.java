package br.com.fiap.orderservice;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String description;
    private BigDecimal unitPrice;
    private Integer quantity;
}
