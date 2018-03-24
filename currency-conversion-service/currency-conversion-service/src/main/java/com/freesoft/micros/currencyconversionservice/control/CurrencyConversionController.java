package com.freesoft.micros.currencyconversionservice.control;

import com.freesoft.micros.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-converter/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String fromCurrency,
                                              @PathVariable String toCurrency,
                                              @PathVariable BigDecimal quantity) {
        return new CurrencyConversion(1L,
                fromCurrency,
                toCurrency,
                BigDecimal.valueOf(65),
                quantity,
                quantity,
                0);

    }
}
