package com.example.telegramservice.telegram;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * Date-12/24/2024
 * By Sardor Tokhirov
 * Time-9:12 PM (GMT+5)
 */
@Configuration
public class TelegramBotConfig {

    @Bean
    public MyTelegramBot myTelegramBot() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        MyTelegramBot bot = new MyTelegramBot();
        telegramBotsApi.registerBot(bot);
        return bot;
    }
}