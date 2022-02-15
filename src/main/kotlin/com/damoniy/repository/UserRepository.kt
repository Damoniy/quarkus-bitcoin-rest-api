package com.damoniy.repository

import com.damoniy.model.User
import io.quarkus.mongodb.panache.kotlin.PanacheMongoRepository
import io.quarkus.panache.common.Parameters
import org.bson.types.ObjectId
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class UserRepository: PanacheMongoRepository<User> {

//    fun updatePassword(password: String?, id: Long): Int {
//        return update("password = :password where id = :id",
//            Parameters.with("id", id).and("password", password))
//    }

    fun findEntity(id: ObjectId): User? {
        return find("id", "620bf6184669922ec43204e4").firstResult()
    }

    fun updateEntity(id: ObjectId, password: String?) {
    this.update("password = :password where id = :id", Parameters.with("password", password).and("id", "id"))
    }
}