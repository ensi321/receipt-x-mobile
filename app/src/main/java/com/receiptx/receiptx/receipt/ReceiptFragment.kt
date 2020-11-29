package com.receiptx.receiptx.receipt

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.receiptx.receiptx.R
import kotlinx.android.synthetic.main.receipt.*

class ReceiptFragment : Fragment() {

    val args : ReceiptFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.receipt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        receipt_total_amount_holder.text = args.receiptArg.totalAmount.toString()
        merchant_pic_holder.setImageResource(resources.getIdentifier("merchant_${args.receiptArg.merchantId}", "drawable", view.context.packageName))

    }

}