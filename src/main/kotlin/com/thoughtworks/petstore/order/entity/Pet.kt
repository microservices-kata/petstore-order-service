package com.thoughtworks.petstore.order.entity

data class Pet(var petId: Long = -1,
               var categoryId: Long = -1,
               var amount: Int = -1,
               var description: String = "") {
}
