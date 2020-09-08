package tech.tokku_engineer.todoappsample_kotlin.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import io.realm.Realm
import io.realm.kotlin.where
import tech.tokku_engineer.todoappsample_kotlin.R
import tech.tokku_engineer.todoappsample_kotlin.TodoItemAdapter
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoListFragmentBinding
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoListFragmentViewModel


class TodoListFragment : Fragment() {
    //realmのインスタンスをfragmentで保持したくない
    //ViewModelに持たせるのが正解か
    private lateinit var realm: Realm
    private lateinit var binding: TodoListFragmentBinding
    private val viewModel: TodoListFragmentViewModel by viewModels()

    // TodoItemがクリックされた時のリスナー
    private val itemClickListener = { todoItem: TodoItem ->
        viewModel.todoItemClicked(todoItem)
    }

    private val fabClickListener = {
        viewModel.createTask()
    }

    companion object {
        fun newInstance() = TodoListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.todo_list_fragment, container, false)
        binding = TodoListFragmentBinding.bind(view).apply {
            viewmodel = viewModel
        }
        binding.lifecycleOwner = this.viewLifecycleOwner

        return view
    }

    /**
     * ActivityCreatedでオブザーブの処理を行う
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //  viewModel = ViewModelProviders.of(this).get(TodoListFragmentViewModel::class.java)
        realm = Realm.getDefaultInstance()

        val todoItem = realm.where<TodoItem>().findAll()
        val adapter = TodoItemAdapter(todoItem, itemClickListener)
        binding.list.adapter = adapter

        binding.floatingActionButton.setOnClickListener { fabClickListener }

        //一覧画面でアイテムがクリックされた時

    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

}