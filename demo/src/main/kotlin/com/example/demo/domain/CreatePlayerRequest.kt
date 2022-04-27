package com.example.demo.domain

import org.jetbrains.annotations.NotNull

class CreatePlayerRequest (

    @NotNull
    val name: String,
    @NotNull
    val club: String,
    @NotNull
    val country: String
)
