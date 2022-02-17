package com.damoniy.model

import io.quarkus.mongodb.panache.PanacheMongoEntity
import org.bson.codecs.pojo.annotations.BsonCreator
import org.bson.codecs.pojo.annotations.BsonProperty

data class User @BsonCreator constructor(
    @BsonProperty("name") var name: String?,
    @BsonProperty("cpf") var CPF: String?,
    @BsonProperty("nickname") var nickname: String?,
    @BsonProperty("password") var password: String?):
    PanacheMongoEntity()