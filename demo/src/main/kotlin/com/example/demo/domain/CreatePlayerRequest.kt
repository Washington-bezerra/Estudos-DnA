package com.example.demo.domain

import org.jetbrains.annotations.NotNull
import javax.validation.constraints.NotEmpty

class CreatePlayerRequest (

    @field:NotNull @field:NotEmpty val name: String,

    @field:NotNull @field:NotEmpty val club: String,

    @field:NotNull @field:NotEmpty val country: String
)
