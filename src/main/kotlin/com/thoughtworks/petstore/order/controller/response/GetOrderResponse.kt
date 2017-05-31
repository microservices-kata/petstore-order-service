package com.thoughtworks.petstore.order.controller.response

import com.thoughtworks.petstore.order.entity.Order

data class GetOrderResponse(var data: List<Order>? = null,
                            var error: String = "") {
}