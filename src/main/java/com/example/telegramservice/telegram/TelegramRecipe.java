package com.example.telegramservice.telegram;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Date-3/6/2025
 * By Sardor Tokhirov
 * Time-6:17 AM (GMT+5)
 */
@Entity
@Table(name = "telegram_recipes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TelegramRecipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  recipeId;

    @Column(name = "number",unique = true)
    private String number;

    private String text;

    @Version
    private Long version;
}
