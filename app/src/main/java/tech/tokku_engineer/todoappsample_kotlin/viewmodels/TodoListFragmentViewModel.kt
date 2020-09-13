package tech.tokku_engineer.todoappsample_kotlin.viewmodels

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.OrderedRealmCollection
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.todo_list_fragment.*
import tech.tokku_engineer.todoappsample_kotlin.TodoItemAdapter
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem

/**
 * TodoListFragmentの表示、データの更新を行う
 * Realmの初期化などはViewModelで行う
 */
class TodoListFragmentViewModel : ViewModel() {
    private lateinit var realm: Realm
    lateinit var todoItems: MutableList<TodoItem>
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
//    fun todoItemClicked(todoItem: TodoItem) {

//        //playMedia(clickedItem, pauseAllowed = false)
//        // showFragment(TodoListFragment.newInstance())
//    }
//
//    fun createTask() {
//
//    }

    // 一覧の取得
    // これはフラグメントがやればよい？
//    fun getTaskList() {
//        realm = Realm.getDefaultInstance()
//        list.layoutManager = LinearLayoutManager(this)
//        val todoItem = realm.where<TodoItem>().findAll()
//        val adapter = TodoItemAdapter(todoItem, itemClickListener)
//        list.adapter = adapter
//    }

    // Todoの完了処理
    fun doneTask() {

    }

    fun deleteTask() {

    }

    private fun getTaskFromId(id: Long) {

    }

}