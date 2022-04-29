package com.example.demo.mapper

import com.example.demo.domain.CreatePlayerRequest
import com.example.demo.entities.Player
import com.example.demo.exception.AlreadyRegisteredException
import com.example.demo.repositories.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import com.example.demo.exception.NotFoundException
import com.example.demo.repositories.PlayerRepository
import org.springframework.stereotype.Service


@Service
class PlayerMapper:Mapper<CreatePlayerRequest, Player>{
    @Autowired
    lateinit var repository: CountryRepository
    @Autowired
    lateinit var playerrepository: PlayerRepository

    override fun map(t: CreatePlayerRequest): Player{

        val countryName = repository.findByName(t.country).orElseThrow{NotFoundException("country not found - " +
                "create a country in http://localhost:8080/country")}
        val playerNotIsRegistered = playerrepository.findByName(t.name).isEmpty

        return if(playerNotIsRegistered){
            Player(
            name = t.name,
            club = t.club,
            country = countryName
            )
        }else{
            return throw AlreadyRegisteredException("The player is already registered")
        }
    }

}

