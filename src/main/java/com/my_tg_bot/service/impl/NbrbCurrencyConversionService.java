package com.my_tg_bot.service.impl;

import com.my_tg_bot.entity.Currency;
import com.my_tg_bot.service.CurrencyConversionService;
import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NbrbCurrencyConversionService implements CurrencyConversionService {
    @Override
    public double getConversionRatio(Currency original, Currency target) {
        double originalRate = getRate(original);
        double targetRate = getRate(target);
        return originalRate / targetRate;
    }

    @SneakyThrows
    private double getRate(Currency currency) {
        if (currency == Currency.BYN) {
            return 1;
        }
        URL url = new URL("https://www.nbrb.by/api/exrates/rates/" + currency.getId());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject json = new JSONObject(response.toString());
        double rate = json.getDouble("Cur_OfficialRate");
        double scale = json.getDouble("Cur_Scale");
        return rate / scale;
    }
}
