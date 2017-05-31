package com.thoughtworks.petstore.order.repository

import com.thoughtworks.petstore.order.entity.Order
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : MongoRepository<Order, ObjectId> {

    fun findByOrderId(orderId: Long): List<Order>
    fun findByUserUserId(userId: Long): List<Order>
    fun findByShopShopId(shopId: Long): List<Order>
}