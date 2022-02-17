package com.damoniy.controller

import com.damoniy.model.User
import com.damoniy.repository.UserRepository
import org.bson.types.ObjectId
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

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
    fun findById(@PathParam("id") id: ObjectId): Response {
        return Response.ok(repository.findEntityById(id)).status(Response.Status.FOUND).build()
    }

    @GET
    @Path("/{name}")
    fun findByName(@PathParam("name") name: String): Response {
        return Response.ok(repository.findEntityByName(name)).status(Response.Status.FOUND).build()
    }

    @GET
    @Path("/cpf/{cpf}")
    fun findByCpf(@PathParam("cpf") name: String): Response {
        return Response.ok(repository.findEntityByCPF(name)).status(Response.Status.FOUND).build()
    }

    @PUT
    @Path("/{id}")
    fun update(@PathParam("id") id: String, body: User): Response {
        return Response.ok(repository.updateEntity(ObjectId(id), body)).status(Response.Status.OK).build()
    }

    @DELETE
    @Path("/{id}")
    fun exclude(@PathParam("id") id: ObjectId): Response {
        repository.deleteById(id)
        return Response.noContent().build()
    }
}