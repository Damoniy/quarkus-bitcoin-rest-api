package com.damoniy.controller

import com.damoniy.model.Order
import com.damoniy.repository.OrderRepository
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.Consumes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType

@Path("/orders")
class OrderController(@Inject var repository: OrderRepository) {

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    fun insert(order: Order){
        repository.persist(order)
    }
}