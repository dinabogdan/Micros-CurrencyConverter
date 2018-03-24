package com.freesoft.micros.currencyconversionservice.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal conversionMultiple;
    private BigDecimal requestedQuantity;
    private BigDecimal totalAmount;

    @Setter
    private int port;
}
