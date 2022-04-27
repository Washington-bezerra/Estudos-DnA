package com.example.demo.mapper

import com.example.demo.domain.CreatePlayerRequest
import com.example.demo.entities.Player
import com.example.demo.repositories.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerMapper:Mapper<CreatePlayerRequest, Player>{
    @Autowired
    lateinit var repository: CountryRepository
    override fun map(t: CreatePlayerRequest): Player {

        return Player(
            name = t.name,
            club = t.club,
            country = repository.findByName(t.country)
        )
    }
}

