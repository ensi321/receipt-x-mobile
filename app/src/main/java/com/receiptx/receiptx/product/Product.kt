package com.receiptx.receiptx.product

import java.time.LocalDate

data class Product(
    val id: Int,
    val storeId: Int,
    val serialNum: String,
    val warranty: LocalDate
)