package com.example.telegramservice.telegram;//package com.example.user_management_service.telegram;

import jdk.jfr.Threshold;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.UUID;

/**
 * Date-12/24/2024
 * By Sardor Tokhirov
 * Time-8:21 PM (GMT+5)
 */
@Service
@Threshold
public class TelegramMessageService {
    private final TelegramRecipeRepository telegramRecipeRepository;

    public TelegramMessageService( TelegramRecipeRepository telegramRecipeRepository) {
        this.telegramRecipeRepository = telegramRecipeRepository;
    }

    public void sendMessageToUser(String number, String messageText) {
        Recipe recipe=new Recipe();
        recipe.setNumber(number);
        recipe.setText(messageText);
        recipe.setRecipeId(UUID.randomUUID());
        telegramRecipeRepository.save(recipe);
    }
}