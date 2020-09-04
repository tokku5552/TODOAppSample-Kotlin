package tech.tokku_engineer.todoappsample_kotlin.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

data class Task(
    val id: Int,
    var title: String,
    var detail: String,
    val createDate: LocalDateTime,
    var updateDate: LocalDateTime,
    var isDone: Boolean,
    var isDelete: Boolean
) {

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateDate() {
        updateDate = LocalDateTime.now()
    }

}