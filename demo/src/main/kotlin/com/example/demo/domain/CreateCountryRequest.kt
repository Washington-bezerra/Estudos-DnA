package com.example.demo.domain

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotEmpty

class CreateCountryRequest(

    @field:NotNull @field:NotEmpty val name: String,

    @field:NotNull @field:NotEmpty val continent: String,
)