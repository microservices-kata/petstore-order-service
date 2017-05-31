package com.thoughtworks.petstore.order.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@ApiModel("Pet Order")
@Document
data class Order(@Id var _id: ObjectId,
                 @ApiModelProperty("Order Id") var orderId: Long,
                 var pet: Pet,
                 var user: User,
                 var shop: Shop) {

    constructor(orderId: Long, pet: Pet, user: User, shop: Shop)
            : this(ObjectId(), orderId, pet, user, shop)

    constructor() : this(ObjectId(), -1, Pet(), User(), Shop())
}
