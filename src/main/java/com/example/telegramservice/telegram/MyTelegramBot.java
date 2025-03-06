package com.example.telegramservice.telegram;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

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
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String chatId = message.getChatId().toString();

            if (message.hasText()) {
                String text = message.getText();

                if (text.equals("/start")) {
                    sendTextMessage(chatId, "Welcome! Use /share_number to send your phone number.");
                } else if (text.equals("/share_number")) {
                    sendContactRequest(chatId);
                }
            }

            // Handle received contact
            else if (message.hasContact()) {
                String phoneNumber = message.getContact().getPhoneNumber();
                sendTextMessage(chatId, "Thank you! Your phone number: " + phoneNumber);
            }
        }
    }

    private void sendTextMessage(String chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendContactRequest(String chatId) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Click the button below to share your phone number:");

        // Create a custom keyboard
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        KeyboardButton contactButton = new KeyboardButton("📞 Share Contact");
        contactButton.setRequestContact(true);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(contactButton);

        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(keyboardRow);

        keyboardMarkup.setKeyboard(keyboardRows);
        keyboardMarkup.setResizeKeyboard(true);
        keyboardMarkup.setOneTimeKeyboard(true);

        message.setReplyMarkup(keyboardMarkup);

        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
