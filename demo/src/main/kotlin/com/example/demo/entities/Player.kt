package com.example.demo.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name="players")
class Player(
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
    var club: String,

    @JoinColumn(name = "country_id")
    @ManyToOne
    @JsonBackReference
    var country: Country
)