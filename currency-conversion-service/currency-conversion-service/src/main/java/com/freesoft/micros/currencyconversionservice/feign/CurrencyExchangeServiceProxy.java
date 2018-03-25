package com.freesoft.micros.currencyconversionservice.feign;

import com.freesoft.micros.currencyconversionservice.bean.CurrencyConversion;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    CurrencyConversion getExchangeValue(@PathVariable("fromCurrency") String fromCurrency,
                                        @PathVariable("toCurrency") String toCurrency);

}
