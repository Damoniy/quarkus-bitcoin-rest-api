package com.damoniy.repository

import com.damoniy.model.User
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository: PanacheMongoRepository<User> {

    fun findEntityById(id: ObjectId): User? {
        return findById(id)
    }

    fun findEntityByName(name: String): User? {
        return find("name", name).firstResult()
    }

    fun findEntityByCPF(cpf: String): User? {
        return find("cpf", cpf).firstResult()
    }

    fun updateEntity(id: ObjectId, body: User): User? {
        this.update("name = ?1 and nickname = ?2 and password = ?3",
            body.name, body.nickname, body.password).where("_id", id)
        return find("_id", id).firstResult()
    }
}