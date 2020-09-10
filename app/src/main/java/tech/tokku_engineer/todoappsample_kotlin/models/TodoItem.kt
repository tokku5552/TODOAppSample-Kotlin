package tech.tokku_engineer.todoappsample_kotlin.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class TodoItem : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var title: String = ""
    var detail: String = ""
    var createDate: Date = Date()
    var updateDate: Date = Date()
    var isDone: Boolean = false
    var isDelete: Boolean = false
    fun updateDate() {
        updateDate = Date()
    }

}