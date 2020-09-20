package com.receiptx.receiptx.receipt

import android.util.Log
import com.receiptx.receiptx.product.Product
import java.io.Serializable
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Receipt(
    var id: Int = -1,
    var issueDate: LocalDate = LocalDate.now(),
    var merchantId: Int = -1,
    var totalAmount: Double = -1.0,
    var productList: List<Product> = emptyList() ) : Serializable {

    fun generateDescriptionText(): String {
        val dateText = "Issued on ${issueDate}"
        val productText = if (productList.size > 1) "${productList.size} items" else "${productList.size} item"

        return "$dateText \n $productText"

    }

    companion object {
        /* Sample: DATE:2020-08-20;MERCHANT_ID:2;TOTAL_AMOUNT:123.2;*/
        fun parseRawData(rawData: String) : Receipt {
            Log.d("Receipt.parseRawData", rawData)
            val strArr = rawData.split(";").toTypedArray()
            val receipt = Receipt()

            for (str in strArr) {
                val fieldName = str.split(":")[0]
                val fieldValue = str.split(":")[1]

                when (fieldName){
                    "DATE" -> receipt.issueDate = LocalDate.parse(fieldValue, DateTimeFormatter.ISO_DATE)
                    "MERCHANT_ID" -> receipt.merchantId = fieldValue.toInt()
                    "TOTAL_AMOUNT" -> receipt.totalAmount = fieldValue.toDouble()
                }
            }

            return receipt

        }
    }

}
