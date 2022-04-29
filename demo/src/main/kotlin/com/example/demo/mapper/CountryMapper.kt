package com.example.demo.mapper

import com.example.demo.domain.CreateCountryRequest
import com.example.demo.entities.Country
import com.example.demo.exception.AlreadyRegistered
import com.example.demo.repositories.CountryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class CountryMapper:Mapper<CreateCountryRequest, Country>{
    @Autowired
    lateinit var repository: CountryRepository

    override fun map(t: CreateCountryRequest): Country{

        var countryNotIsRegistered = repository.findByName(t.name).isEmpty

        return if(countryNotIsRegistered){
            Country(
                name = t.name,
                continent = t.continent
            )
        }else{
            throw AlreadyRegistered("The country is already registered")
        }



    }

}

