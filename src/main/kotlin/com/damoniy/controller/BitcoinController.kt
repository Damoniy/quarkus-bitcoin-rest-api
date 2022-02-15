package com.damoniy.controller

import com.damoniy.model.Bitcoin
import com.damoniy.service.BitcoinService
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("bitcoins")
class BitcoinController() {

    @Inject
    @RestClient
    lateinit var service: BitcoinService

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun list(): List<Bitcoin> {
        return service.list();
    }

}