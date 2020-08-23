package com.receiptx.receiptx.receipt

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.receiptx.receiptx.R
import java.io.Serializable

class ReceiptAdapter(private val receipts: List<Receipt>, private val activity: Activity) :
    RecyclerView.Adapter<ReceiptAdapter.ViewHolder>() {

    class ViewHolder(private val view: View, private val activity: Activity) : RecyclerView.ViewHolder(view) {

        fun bind(receipt: Receipt) {
            val resources = view.context.resources
            view.setOnClickListener {
                Log.i("LOG_INFO", "Switching to Receipt Activity")
                val myIntent = Intent(activity, ReceiptActivity::class.java)
                myIntent.putExtra("receipt", "value")

                // TODO Uncomment below after implementing Receipt serialization : https://github.com/naviechan/receipt-x-mobile/issues/8
                // myIntent.putExtra("receipt", receipt as Serializable)
                activity.startActivity(myIntent)
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
        return ViewHolder(view, activity)
    }

    override fun getItemCount(): Int {
        return receipts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val receiptInfo = receipts[position]
        holder.bind(receiptInfo)
    }

}