package com.example.telegramservice.telegram;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Date-12/24/2024
 * By Sardor Tokhirov
 * Time-8:24 PM (GMT+5)
 */

@Service
public class MyTelegramBot extends TelegramLongPollingBot {

    private final String botToken = "7753134071:AAHGgpu9GKyJs6sJ0lMTwg70l5fv2p9efZs";

    @Override
    public String getBotUsername() {
        return "@world_medicine_bot";
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String chatId = update.getMessage().getChatId().toString();
            String response = "Your Telegram ID: " + chatId;
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(response);
            try {
                execute(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}