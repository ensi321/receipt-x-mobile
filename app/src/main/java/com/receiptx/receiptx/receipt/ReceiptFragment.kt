package com.receiptx.receiptx.receipt

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val receipt = args.receiptArg

        val image = resources.getIdentifier("merchant_${receipt.merchantId}", "drawable", view.context.packageName)
        businessImage.setImageResource(image)

        totalAmount.text = "$${receipt.totalAmount}"

        receiptDate.text = receipt.issueDate.toString()

    }

}