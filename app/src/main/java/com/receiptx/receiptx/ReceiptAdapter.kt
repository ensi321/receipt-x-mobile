package com.receiptx.receiptx

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.receiptx.receiptx.receipt.Receipt
import java.text.SimpleDateFormat

class ReceiptAdapter(private val receipts: List<Receipt>) :
    RecyclerView.Adapter<ReceiptAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(receipt: Receipt) {
            view.findViewById<TextView>(R.id.receipt_id_holder).text = "${receipt.id}"
            view.findViewById<TextView>(R.id.num_product_holder).text = "${receipt.productList.size}"

            d("receipt adapter","${receipt.issueDate}")
            view.findViewById<TextView>(R.id.issue_date_holder).text = "${receipt.issueDate}"

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.receipt_info, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return receipts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val receiptInfo = receipts[position]
        holder.bind(receiptInfo)
    }

}