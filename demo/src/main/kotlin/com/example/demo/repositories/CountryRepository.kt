package com.example.demo.repositories

import com.example.demo.entities.Country
import com.example.demo.entities.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository: JpaRepository<Country, Long>{

    fun findByName(name: String):Country

}