package com.example

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.database.Task


@BindingAdapter("valueTitleFormatted")
fun TextView.setItemNameFormated(item : Task?) {
    item?.let {
        text = it.itemName
    }
}
@BindingAdapter("valueContentFormatted")
fun TextView.setIsCompletedFormated(item : Task?) {
    item?.let {
        text = it.isCompleted.toString()
    }
}