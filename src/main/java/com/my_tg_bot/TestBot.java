package com.my_tg_bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TestBot extends TelegramLongPollingBot {

    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) { 
                execute(SendMessage.builder().
                        chatId(message.getChatId().toString())
                        .text("You sent: \n\n" + message.getText())
                        .build());
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "@DG Test Bot";
    }

    @Override
    public String getBotToken() {
        return "5133078789:AAHy21NEem5_mQLOAUwLKJ3fC8c04IJKyrE";
    }

    @SneakyThrows
    public static void main(String[] args) {
        TestBot testBot = new TestBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(testBot);
    }
}
