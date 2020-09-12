package tech.tokku_engineer.todoappsample_kotlin.viewmodels

import android.text.Editable
import androidx.lifecycle.ViewModel
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import java.util.*

class TodoItemDetailFragmentViewModel : ViewModel() {
    private var realm = Realm.getDefaultInstance()

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

    fun getTask() {
        // realm = Realm.getDefaultInstance()
//        list.layoutManager = LinearLayoutManager(this)
//        val todoItem = realm.where<TodoItem>().findAll()
//        val adapter = TodoItemAdapter(todoItem, itemClickListener)
//        list.adapter = adapter
    }

    // TodoItemの内容を更新する
    fun updateTask() {

    }

    //TodoItemを削除する
    fun deleteTask() {

    }
}