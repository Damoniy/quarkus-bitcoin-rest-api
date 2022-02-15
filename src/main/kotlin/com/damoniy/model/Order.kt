package com.damoniy.model

import io.quarkus.hibernate.orm.panache.PanacheEntityBase
import java.time.LocalDateTime
import javax.persistence.*

//@Entity
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
    var price: Double?,
    var type: String?,
    var date: LocalDateTime?,
    var status: String?,
    @Column(name = "user_id") var user_id: Long?)