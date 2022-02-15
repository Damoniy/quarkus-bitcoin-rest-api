package com.damoniy.controller

import com.damoniy.model.User
import com.damoniy.repository.UserRepository
import org.bson.types.ObjectId
import javax.inject.Inject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class UserController(@Inject var repository: UserRepository) {

    @POST
    fun insert(user: User) {
        repository.persist(user)
    }

    @GET
    fun consult(): List<User> {
        return repository.listAll()
    }

    @GET
    @Path("/{id}")
    fun findById(@PathParam("id") id: ObjectId): User? {
        return repository.findEntity(id)
    }

    @PUT
    @Path("/{id}")

    fun updatePassword(@PathParam("id") id: ObjectId, user: User) {
        return repository.updateEntity(id, user.password)
    }

    @DELETE
    @Path("/{id}")
    fun exclude(@PathParam("id") id: ObjectId) {
        repository.deleteById(id)
    }
}