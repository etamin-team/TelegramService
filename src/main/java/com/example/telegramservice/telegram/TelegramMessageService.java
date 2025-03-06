package com.example.telegramservice.telegram;//package com.example.user_management_service.telegram;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.UUID;

/**
 * Date-12/24/2024
 * By Sardor Tokhirov
 * Time-8:21 PM (GMT+5)
 */
@Service
public class TelegramMessageService {
    private final MyTelegramBot bot;
    private final TelegramRecipeRepository telegramRecipeRepository;

    public TelegramMessageService(MyTelegramBot bot, TelegramRecipeRepository telegramRecipeRepository) {
        this.bot = bot;
        this.telegramRecipeRepository = telegramRecipeRepository;
    }

    public void sendMessageToUser(String number, String messageText) {
        Recipe recipe=new Recipe();
        recipe.setNumber(number);
        recipe.setText(messageText);
        recipe.setRecipeId(UUID.randomUUID());
        try {
            telegramRecipeRepository.save(recipe);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}