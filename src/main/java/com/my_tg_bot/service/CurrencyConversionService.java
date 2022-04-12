package com.my_tg_bot.service;

import com.my_tg_bot.entity.Currency;
import com.my_tg_bot.service.impl.NbrbCurrencyConversionService;

public interface CurrencyConversionService {

    static CurrencyConversionService getInstance(){
        return new NbrbCurrencyConversionService();
    }

    double getConversionRatio(Currency original, Currency target);
}
