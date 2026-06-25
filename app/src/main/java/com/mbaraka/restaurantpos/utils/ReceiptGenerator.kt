package com.mbaraka.restaurantpos.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object ReceiptGenerator {

    fun generateReceiptNumber(sequence: Int): String {

        val date = SimpleDateFormat(
            "yyyyMMdd",
            Locale.getDefault()
        ).format(Date())

        return "VP-$date-${sequence.toString().padStart(4, '0')}"
    }
}