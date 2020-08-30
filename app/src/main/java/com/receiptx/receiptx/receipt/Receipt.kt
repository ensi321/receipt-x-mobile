package com.receiptx.receiptx.receipt

import java.io.Serializable
import com.receiptx.receiptx.product.Product
import java.time.LocalDate

// TODO Implementing Receipt Serialization : https://github.com/naviechan/receipt-x-mobile/issues/8
data class Receipt(
    val id: Int,
    val issueDate: LocalDate,
    val merchantId: Int,
    val totalAmount: Double,
    val productList: List<Product>) : Serializable {

    fun generateDescriptionText(): String {
        val dateText = "Issued on ${issueDate}"
        val productText = if (productList.size > 1) "${productList.size} items" else "${productList.size} item"

        return "$dateText \n $productText"
    }

}
