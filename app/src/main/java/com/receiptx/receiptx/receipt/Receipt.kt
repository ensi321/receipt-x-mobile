package com.receiptx.receiptx.receipt

import com.receiptx.receiptx.product.Product
import java.time.LocalDate

data class Receipt(
    val id: Int,
    val issueDate: LocalDate,
    val productList: List<Product>)
