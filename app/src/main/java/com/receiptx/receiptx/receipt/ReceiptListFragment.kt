package com.receiptx.receiptx.receipt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.receiptx.receiptx.R
import com.receiptx.receiptx.product.Product
import java.time.LocalDate

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ReceiptListFragment : Fragment() {

    companion object {
        var receiptItems : MutableList<Receipt> = mutableListOf(
            Receipt(1, LocalDate.of( 2020 , 8 , 20 ), 1, 12.34,
                listOf(Product(1, 1, "000", LocalDate.of(2023, 8, 20)))),
            Receipt(2, LocalDate.of( 2020 , 8 , 21 ), 2, 222.35,
                listOf(
                    Product(1, 1, "002", LocalDate.of(2023, 8, 20)),
                    Product(1, 1, "002", LocalDate.of(2024, 8, 20))
                )),
            Receipt(3, LocalDate.of( 2020 , 8 , 22 ), 3, 12.34,
                listOf(
                    Product(1, 1, "002", LocalDate.of(2023, 8, 20)),
                    Product(1, 1, "002", LocalDate.of(2024, 8, 20))
                )),
            Receipt(1, LocalDate.of( 2020 , 8 , 20 ), 4, 13.78,
                listOf(Product(1, 1, "000", LocalDate.of(2023, 8, 20)))),
            Receipt(2, LocalDate.of( 2020 , 8 , 21 ), 2, 13.56,
                listOf(Product(1, 1, "001", LocalDate.of(2023, 8, 20)))),
            Receipt(3, LocalDate.of( 2020 , 8 , 22 ), 1, 12.34,
                listOf(
                    Product(1, 1, "002", LocalDate.of(2023, 8, 20)),
                    Product(1, 1, "002", LocalDate.of(2024, 8, 20))
                )),
            Receipt(1, LocalDate.of( 2020 , 8 , 20 ), 4, 12.34,
                listOf(Product(1, 1, "000", LocalDate.of(2023, 8, 20)))),
            Receipt(2, LocalDate.of( 2020 , 8 , 21 ), 3, 13.56,
                listOf(Product(1, 1, "001", LocalDate.of(2023, 8, 20)))),
            Receipt(3, LocalDate.of( 2020 , 8 , 22 ), 1, 12.34,
                listOf(
                    Product(1, 1, "002", LocalDate.of(2023, 8, 20)),
                    Product(1, 1, "002", LocalDate.of(2024, 8, 20))
                )),
            Receipt(1, LocalDate.of( 2020 , 8 , 20 ), 2, 12.34,
                listOf(Product(1, 1, "000", LocalDate.of(2023, 8, 20)))),
            Receipt(2, LocalDate.of( 2020 , 8 , 21 ), 2, 13.56,
                listOf(Product(1, 1, "001", LocalDate.of(2023, 8, 20)))),
            Receipt(3, LocalDate.of( 2020 , 8 , 22 ), 4, 12.34,
                listOf(
                    Product(1, 1, "002", LocalDate.of(2023, 8, 20)),
                    Product(1, 1, "002", LocalDate.of(2024, 8, 20))
                ))
        )
    }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.receipt_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.ReceiptListRecylerView).apply {
            layoutManager = LinearLayoutManager(activity)
            adapter =
                ReceiptAdapter(receiptItems)
        }

    }
}