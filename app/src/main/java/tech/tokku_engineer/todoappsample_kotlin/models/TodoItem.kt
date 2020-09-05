package tech.tokku_engineer.todoappsample_kotlin.models

import android.os.Build
import androidx.annotation.RequiresApi
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.time.LocalDateTime

open class TodoItem : RealmObject() {
    @PrimaryKey
    var id: Int = 0
    var title: String = ""
    var detail: String = ""

    @RequiresApi(Build.VERSION_CODES.O)
    val createDate: LocalDateTime = LocalDateTime.now()

    @RequiresApi(Build.VERSION_CODES.O)
    var updateDate: LocalDateTime = LocalDateTime.now()
    var isDone: Boolean = false
    var isDelete: Boolean = false

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateDate() {
        updateDate = LocalDateTime.now()
    }

}