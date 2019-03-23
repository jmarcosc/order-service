package br.com.fiap.orderservice;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String email;
    private String fullName;
    private String shippingAddress;
    private List<Item> items;
    private Payment payment;
    private BigDecimal totalPrice;
    private String date;
    private String status;
}
