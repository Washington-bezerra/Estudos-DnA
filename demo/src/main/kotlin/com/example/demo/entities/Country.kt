package com.example.demo.entities

import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.annotations.GenericGenerator
import org.jetbrains.annotations.NotNull
import java.util.*
import javax.persistence.*

@Entity
@Table(name="country")
class Country (

    @Column
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator",
    )
    var id: UUID? = null,

    @Column
    var name: String,

    @Column
    var continent: String,

    @Column
    @OneToMany(
        targetEntity = Player::class,
        mappedBy = "country"
    )
    @JsonManagedReference
    var players: List<Player>? = null

)