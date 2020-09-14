package tech.tokku_engineer.todoappsample_kotlin.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun String.toDate(pattern: String = "yyyy/MM/dd"): Date? {
    return SimpleDateFormat(pattern).parse(this)
}

@SuppressLint("SimpleDateFormat")
fun Date.toString(pattern: String = "yyyy/MM/dd"): String? {
    return SimpleDateFormat(pattern).format(this)

}