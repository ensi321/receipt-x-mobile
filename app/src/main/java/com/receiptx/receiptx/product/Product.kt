package com.receiptx.receiptx.product

import java.util.Date

data class Product(
    val id: Int,
    val storeId: Int,
    val serialNum: String,
    val warranty: Date)