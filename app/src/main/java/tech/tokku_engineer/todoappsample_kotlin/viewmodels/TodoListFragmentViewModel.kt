package tech.tokku_engineer.todoappsample_kotlin.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.realm.OrderedRealmCollection
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import java.util.*

/**
 * TodoListFragmentの表示、データの更新を行う
 * Realmの初期化などはViewModelで行う
 */
class TodoListFragmentViewModel : ViewModel() {
    private lateinit var realm: Realm
    private lateinit var todoItems: MutableList<TodoItem>
    lateinit var title: MutableLiveData<String>
    lateinit var data: OrderedRealmCollection<TodoItem>

    init {
        updateUI()
    }

    fun updateUI() {
        realm = Realm.getDefaultInstance()
        todoItems = realm.where<TodoItem>().findAll()
        data = (todoItems as RealmResults<TodoItem>?)!!
    }

    // 完了済みタスクは未完了に、未完了タスクは完了済みに変更する
    fun isDoneStateChange(id: Long) {
        realm.executeTransaction { db: Realm ->
            val todoItem = db.where<TodoItem>()
                .equalTo("id", id).findFirst()
            todoItem?.isDone = !todoItem?.isDone!!
        }
    }

    fun deleteTask() {

    }

}