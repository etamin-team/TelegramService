package com.example.telegramservice.telegram;//package com.example.user_management_service.telegram;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Date-12/24/2024
 * By Sardor Tokhirov
 * Time-8:21 PM (GMT+5)
 */

@RestController
@RequestMapping("/telegram")
public class TelegramController {
    private final TelegramMessageService messageService;

    private final MyTelegramBot myTelegramBot;

    public TelegramController( TelegramMessageService messageService, MyTelegramBot myTelegramBot) {
        this.messageService = messageService;
        this.myTelegramBot = myTelegramBot;
    }
 
    @PostMapping("/send-message")
    public ResponseEntity<String> sendMessage(@RequestParam Long number, @RequestParam String message) {

            messageService.sendMessageToUser(String.valueOf(number), message);
            return ResponseEntity.ok("Message sent!");
    }

    @GetMapping("/get-user-data")
    public ResponseEntity<?> getUserData(@RequestParam Long userId) {
        try {
            GetChat getChat = new GetChat();
            getChat.setChatId(String.valueOf(userId));

            Chat chat = myTelegramBot.execute(getChat);

            return ResponseEntity.ok(chat);
        } catch (TelegramApiException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving user data: " + e.getMessage());
        }
    }
}