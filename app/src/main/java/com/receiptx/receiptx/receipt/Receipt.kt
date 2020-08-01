package com.receiptx.receiptx.receipt

import com.receiptx.receiptx.product.Product
import java.util.Date

data class Receipt(
    val id: Int,
    val issueDate: Date,
    val productList: List<Product>)
