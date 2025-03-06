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
public interface TelegramRecipeRepository extends JpaRepository<Recipe, UUID> {

    @Query("SELECT ac FROM Recipe ac WHERE ac.number = :number ORDER BY ac.recipeId asc limit 1")
    Optional<Recipe> findByNumber(@Param("number")  String number);
}
