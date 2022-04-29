package com.example.demo.controllers

import com.example.demo.domain.CreateCountryRequest
import com.example.demo.entities.Country
import com.example.demo.entities.Player
import com.example.demo.mapper.CountryMapper
import com.example.demo.repositories.CountryRepository
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
    fun delete(@PathVariable("id") id:Long){
        var country = repository.findById(id).orElseThrow{ EntityNotFoundException()}
        repository.delete(country)
    }
}