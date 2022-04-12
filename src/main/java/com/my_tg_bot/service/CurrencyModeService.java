package com.my_tg_bot.service;

import com.my_tg_bot.entity.Currency;
import com.my_tg_bot.service.impl.HashMapCurrencyModeService;

public interface CurrencyModeService {

    static CurrencyModeService getInstance(){
        return new HashMapCurrencyModeService();
    }

    Currency getOriginalCurrency(long chatId);

    Currency getTargetCurrency(long chatId);

    void setOriginalCurrency(long chatId, Currency currency);

    void setTargetCurrency(long chatId, Currency currency);
}
