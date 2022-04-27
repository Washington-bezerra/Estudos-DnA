package com.example.demo.repositories

import com.example.demo.entities.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PlayerRepository: JpaRepository<Player, Long> {

    //@Query("SELECT * FROM Player")
    //fun finPlayerByCountry(): List<Player>

}