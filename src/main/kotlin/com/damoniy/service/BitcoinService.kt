package com.damoniy.service

import com.damoniy.model.Bitcoin
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/bitcoins")
@RegisterRestClient
interface BitcoinService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun list(): List<Bitcoin>

}