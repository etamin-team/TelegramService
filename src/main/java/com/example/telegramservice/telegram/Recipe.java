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
public class Recipe {
    @Id
        @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "recipe_id", columnDefinition = "uuid")
    private UUID recipeId;


    @Column(name = "number")
    private String number;

    private String text;
}
