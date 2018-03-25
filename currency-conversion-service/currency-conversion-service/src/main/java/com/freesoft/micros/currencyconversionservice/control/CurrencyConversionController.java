package com.freesoft.micros.currencyconversionservice.control;

import com.freesoft.micros.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @GetMapping("/currency-converter/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion convertCurrency(@PathVariable String fromCurrency,
                                              @PathVariable String toCurrency,
                                              @PathVariable BigDecimal quantity) {


        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("fromCurrency", fromCurrency);
        uriVariables.put("toCurrency", toCurrency);
        ResponseEntity<CurrencyConversion> responseEntity =
                new RestTemplate().getForEntity(
                        "http://localhost:8000//currency-exchange/from/{fromCurrency}/to/{toCurrency}",
                        CurrencyConversion.class,
                        uriVariables);

        CurrencyConversion response = responseEntity.getBody();


        return new CurrencyConversion(response.getId(),
                fromCurrency,
                toCurrency,
                response.getConversionMultiple(),
                quantity,
                quantity.multiply(response.getConversionMultiple()),
                response.getPort());

    }
}
