package br.com.fiap.orderservice;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private String transactionId;
    private String cardNumber;
    private String expirationDate;
    private String flag;
}
