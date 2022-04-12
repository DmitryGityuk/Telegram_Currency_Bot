package com.my_tg_bot.service.impl;

import com.my_tg_bot.entity.Currency;
import com.my_tg_bot.service.CurrencyConversionService;

public class HardcodedCurrencyConversionService implements CurrencyConversionService {
    @Override
    public double getConversionRatio(Currency from, Currency to) {
        switch (from) {
            case BYN:
                switch (to) {
                    case USD:
                        return 1 / 2.5;
                    case EUR:
                        return 1 / 3.1;
                    case BYN:
                        return 1;
                }
            case EUR:
                switch (to) {
                    case USD:
                        return 1.1;
                    case EUR:
                        return 1;
                    case BYN:
                        return 3.1;
                }
            case USD:
                switch (to) {
                    case USD:
                        return 1;
                    case EUR:
                        return 1 / 1.1;
                    case BYN:
                        return 2.5;
                }
        }
        return 1;
    }
}
