package com.example.demo.controllers

import com.example.demo.domain.CreateCountryRequest
import com.example.demo.entities.Country
import com.example.demo.exception.BadRequestException
import com.example.demo.exception.NotFoundException
import com.example.demo.mapper.CountryMapper
import com.example.demo.repositories.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.HttpClientErrorException.BadRequest
import java.util.*
import javax.persistence.EntityNotFoundException
import javax.validation.Valid

@RestController
@RequestMapping("/country")
class CountryController {

    @Autowired
    lateinit var repository: CountryRepository
    @Autowired
    lateinit var countryMapper: CountryMapper

    @GetMapping
    fun list(): List<Country>{
        var contry = repository.findAll()
        return contry
    }

    @PostMapping
    fun create(@RequestBody @Valid createCountryRequest: CreateCountryRequest): Country{
        var country: Country = countryMapper.map(createCountryRequest)
        return repository.save(country)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Long, @RequestBody newCountry: Country) : Country{
        var country = repository.findById(id).orElseThrow{ EntityNotFoundException()}

        country.apply {
            this.name = newCountry.name
            this.continent = newCountry.continent
        }

        return repository.save(country)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id:UUID){

        var country = repository.findById(id).orElseThrow{NotFoundException("ID not found")}
        if(country.players.isNullOrEmpty()){
            repository.delete(country)
        }else{
            return throw BadRequestException("It is not possible to delete a country that has a player(s), " +
                    "first delete or updete the player(s)")
        }
    }
}