package com.example.demo.mapper

import com.example.demo.domain.CreatePlayerRequest
import com.example.demo.entities.Player
import com.example.demo.repositories.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import com.example.demo.exception.NotFoundException
import org.springframework.stereotype.Service
import java.util.Optional


@Service
class PlayerMapper:Mapper<CreatePlayerRequest, Player>{
    @Autowired
    lateinit var repository: CountryRepository

    override fun map(t: CreatePlayerRequest): Player{

        val test = repository.findByName(t.country).orElseThrow{NotFoundException("country not found")}
//        val test = repository.findByName(t.country) ?: throw NotFoundException("Country not found")

        return Player(
            name = t.name,
            club = t.club,
            country = repository.findByName(t.country)
        )
    }
}

