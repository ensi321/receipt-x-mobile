package com.receiptx.receiptx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.receiptx.receiptx.receipt.Receipt
import com.receiptx.receiptx.ReceiptListFragmentDirections

class ReceiptAdapter(private val receipts: List<Receipt>) :
    RecyclerView.Adapter<ReceiptAdapter.ViewHolder>() {

    class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(receipt: Receipt) {
            val resources = view.context.resources

            view.setOnClickListener {
                val action = ReceiptListFragmentDirections.actionFirstFragmentToProductInfo(receipt)
                view.findNavController().navigate(action)

            }
            view.findViewById<TextView>(R.id.description_holder).text = receipt.generateDescriptionText()
            view.findViewById<TextView>(R.id.total_amount_holder).text = resources.getString(R.string.prefix_dollar, receipt.totalAmount)
            view.findViewById<ImageView>(R.id.merchant_pic_holder)
                .setImageResource(resources.getIdentifier("merchant_${receipt.merchantId}", "drawable", view.context.packageName))

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