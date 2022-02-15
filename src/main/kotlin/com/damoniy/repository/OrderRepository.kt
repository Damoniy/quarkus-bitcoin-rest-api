package com.damoniy.repository

import com.damoniy.model.Order
import io.quarkus.hibernate.orm.panache.PanacheRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class OrderRepository: PanacheRepository<Order>