package com.example.telegramservice.telegram;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Date-3/6/2025
 * By Sardor Tokhirov
 * Time-6:33 AM (GMT+5)
 */
@Repository
public interface TelegramRecipeRepository extends JpaRepository<TelegramRecipe, UUID> {

    @Query("SELECT ac FROM TelegramRecipe ac WHERE ac.number = :number")
    Optional<TelegramRecipe> findByNumber(@Param("number")  String number);
}
