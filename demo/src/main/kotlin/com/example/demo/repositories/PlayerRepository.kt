package com.example.demo.repositories

import com.example.demo.entities.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface PlayerRepository: JpaRepository<Player, Long> {
    fun findByName(name: String): Optional<Player>

    fun findByid(id: UUID): Optional<Player>
}