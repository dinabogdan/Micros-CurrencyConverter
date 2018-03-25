package com.freesoft.micros.currencyconversionservice.feign;

import com.freesoft.micros.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service",
        url = "localhost:8000")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    CurrencyConversion getExchangeValue(@PathVariable("fromCurrency") String fromCurrency,
                                        @PathVariable("toCurrency") String toCurrency);

}
