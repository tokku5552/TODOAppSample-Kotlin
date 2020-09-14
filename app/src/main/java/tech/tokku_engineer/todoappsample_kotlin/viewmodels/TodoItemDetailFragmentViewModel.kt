package tech.tokku_engineer.todoappsample_kotlin.viewmodels

import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import java.util.*

class TodoItemDetailFragmentViewModel : ViewModel() {
    private var realm = Realm.getDefaultInstance()
    var id: Int = 0

    // TodoItemを新規作成する
    fun createNewTask(title: String, detail: String?) {
        realm.executeTransaction { db: Realm ->
            val maxId = db.where<TodoItem>().max("id")
            val nextId = (maxId?.toLong() ?: 0L) + 1
            val todoItem = db.createObject<TodoItem>(nextId)
            todoItem.title = title
            todoItem.detail = detail ?: ""
            todoItem.createDate = Date()
        }
        //通知かなんかだす
    }

    // TodoItemの内容を更新する
    fun updateTask(id: Long, title: String, detail: String?) {
        realm.executeTransaction { db: Realm ->
            val todoItem = db.where<TodoItem>()
                .equalTo("id", id).findFirst()
            todoItem?.title = title
            todoItem?.detail = detail ?: ""
            todoItem?.updateDate = Date()
        }
        //通知かなんかだす
    }

    //TodoItemを削除する
    fun deleteTask() {

    }
}