package com.damoniy.model

import java.time.LocalDate

data class Bitcoin(private val id: Int,
                   private val price: Double,
                   private val type: String,
                   private val date: LocalDate)