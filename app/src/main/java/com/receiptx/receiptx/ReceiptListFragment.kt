package com.receiptx.receiptx

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.receiptx.receiptx.product.Product
import com.receiptx.receiptx.receipt.Receipt
import java.time.LocalDate
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ReceiptListFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.receipt_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /* Hardcode receipt objects here*/
        val receiptItems = listOf<Receipt>(
            Receipt(1, LocalDate.of( 2020 , 8 , 20 ), listOf(Product(1, 1, "000", LocalDate.of(2023, 8, 20)))),
            Receipt(2, LocalDate.of( 2020 , 8 , 21 ), listOf(Product(2, 13, "001", LocalDate.of(2023, 8, 20)))),
            Receipt(3, LocalDate.of( 2020 , 8 , 22 ), listOf(Product(3, 21, "002", LocalDate.of(2023, 8, 20))))
        )

        view.findViewById<RecyclerView>(R.id.ReceiptListRecylerView).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ReceiptAdapter(receiptItems)
        }

    }
}