package tech.tokku_engineer.todoappsample_kotlin.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.realm.OrderedRealmCollection
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem

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

    fun openTodoItem(){

    }

    // Todoの完了処理
    fun doneTask() {

    }

    fun deleteTask() {

    }

    private fun getTaskFromId(id: Long) {

    }

}