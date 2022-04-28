package com.example.demo.controllers

import com.example.demo.domain.CreatePlayerRequest
import com.example.demo.entities.Player
import com.example.demo.mapper.PlayerMapper
import com.example.demo.repositories.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/player")
class PlayerController {

    @Autowired
    lateinit var repository: PlayerRepository

    @Autowired
    lateinit var playerMapper: PlayerMapper

    @GetMapping
    fun list(): List<Player>{
        return repository.findAll()
    }

    @PostMapping
    fun create(@RequestBody createPlayerRequest: CreatePlayerRequest): Player {

        var player: Player = playerMapper.map(createPlayerRequest)
        return repository.save(player)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody newPlayer: Player) : Player{
        var player = repository.findById(id).orElseThrow{ EntityNotFoundException()}

        player.apply {
            this.name = newPlayer.name
            this.club = newPlayer.club
            this.country = newPlayer.country
        }

        return repository.save(player)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id:Long){
        var player = repository.findById(id).orElseThrow{ EntityNotFoundException()}
        repository.delete(player)
    }

}