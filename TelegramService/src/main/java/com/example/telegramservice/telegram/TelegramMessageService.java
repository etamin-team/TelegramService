package com.example.telegramservice.telegram;//package com.example.user_management_service.telegram;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * Date-12/24/2024
 * By Sardor Tokhirov
 * Time-8:21 PM (GMT+5)
 */
@Service
public class TelegramMessageService {
    private final MyTelegramBot bot;

    public TelegramMessageService(MyTelegramBot bot) {
        this.bot = bot;
    }

    public void sendMessageToUser(String chatId, String messageText) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(messageText);
        try {
            bot.execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}