package tech.tokku_engineer.todoappsample_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.todo_list_fragment.*
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoListFragmentViewModel
import tech.tokku_engineer.todoappsample_kotlin.views.TodoItemDetailFragment

/**
 * Fragmentの生成、画面遷移のみ行う
 */
class MainActivity : AppCompatActivity() {

    private lateinit var realm: Realm
    private lateinit var todoListItemViewModel: TodoListFragmentViewModel

    private val itemClickListener = { todoItem: TodoItem ->
        todoListItemViewModel.todoItemClicked(todoItem)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Realmのインスタンス取得
        realm = Realm.getDefaultInstance()
        //　本来TodoListFragmentでリストアダプターをバインドすべき
        list.layoutManager = LinearLayoutManager(this)
        val todoItem = realm.where<TodoItem>().findAll()
        val adapter = TodoItemAdapter(todoItem, itemClickListener)
        list.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        // Realmインスタンスの破棄
        realm.close()
    }
}