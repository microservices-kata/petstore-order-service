package com.thoughtworks.petstore.order.controller

import com.thoughtworks.petstore.order.controller.response.GetOrderResponse
import com.thoughtworks.petstore.order.entity.Order
import com.thoughtworks.petstore.order.repository.OrderRepository
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping(value = "/api/orders")
class OrderController {

    @Autowired
    lateinit var orderRepository: OrderRepository

    @ApiOperation(value = "Get order via user or shop id")
    @RequestMapping(value = "", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getOrders(@ApiParam(value = "Query via user id")
                  @RequestParam(required = false, defaultValue = "-1") userId: Long,
                  @ApiParam(value = "Query via shop id")
                  @RequestParam(required = false, defaultValue = "-1") shopId: Long): GetOrderResponse {
        return when {
            userId >= 0L && shopId < 0L ->
                GetOrderResponse(data = orderRepository.findByUserUserId(userId))
            userId < 0L && shopId >= 0L ->
                GetOrderResponse(data = orderRepository.findByShopShopId(shopId))
            else -> ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(GetOrderResponse(error = "Should specify either petId or shopId")).body
        }
    }

    @ApiOperation(value = "Get order via order id")
    @RequestMapping(value = "/{orderId}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun getOrder(@ApiParam(value = "Order id") @PathVariable orderId: Long): GetOrderResponse {
        return GetOrderResponse(data = orderRepository.findByOrderId(orderId))
    }

    @ApiOperation(value = "Create new order")
    @RequestMapping(value = "", method = arrayOf(RequestMethod.POST))
    fun createOrder(@RequestBody order: Order): Order {
        return orderRepository.save(order)
    }

}
