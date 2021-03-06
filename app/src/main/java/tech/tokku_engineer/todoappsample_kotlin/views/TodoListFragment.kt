package tech.tokku_engineer.todoappsample_kotlin.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import tech.tokku_engineer.todoappsample_kotlin.R
import tech.tokku_engineer.todoappsample_kotlin.TodoItemAdapter
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoListFragmentBinding
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.MainActivityViewModel
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoListFragmentViewModel

private const val TAG = "TodoListFragment"

class TodoListFragment : Fragment() {

    private lateinit var binding: TodoListFragmentBinding
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()
    private val todoListFragmentViewModel: TodoListFragmentViewModel by viewModels()

    companion object {
        fun newInstance() = TodoListFragment()
    }

    /**
     * Fragmentの表示とデータバインドの初期化のみ
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "called onCreateView")
        val view = inflater.inflate(R.layout.todo_list_fragment, container, false)
        binding = TodoListFragmentBinding.bind(view).apply {
            viewmodel = todoListFragmentViewModel
        }
        binding.lifecycleOwner = this.viewLifecycleOwner
        return view
    }

    /**
     * ActivityCreatedでbindingやリスナーのセットを行う
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "called onActivityCreated")

        // adapterのバインド処理
        val adapter = TodoItemAdapter(todoListFragmentViewModel)
        binding.list.adapter = adapter

        //TodoItemをクリックしたときに詳細画面を表示する
        adapter.setOnItemClickListener(object : TodoItemAdapter.OnItemClickListener {
            override fun onItemClickListener(todoItem: TodoItem, position: Int) {
                Log.d(TAG, "called onItemClickListener")
                mainActivityViewModel.todoItemClicked(todoItem)
            }
        })
        // TodoItemを長押ししたときは、TodoItemを削除する
        adapter.setOnLongItemClickListener(object : TodoItemAdapter.OnLongItemClickListener {
            override fun onLongItemClickListener(todoItem: TodoItem, position: Int): Boolean {
                Log.d(TAG, "called onLongItemClickListener")
                todoListFragmentViewModel.deleteTask(todoItem)
                return true
            }
        })
        // checkBoxの状態を変更する
        adapter.setOnCheckBoxClickListener(object : TodoItemAdapter.OnCheckBoxClickListener {
            override fun onCheckBoxClickListener(todoItem: TodoItem, position: Int) {
                Log.d(TAG, "called onCheckBoxClickListener")
                todoListFragmentViewModel.isDoneStateChange(todoItem.id)
                todoListFragmentViewModel.updateUI()
            }
        })
        // FABを押したら新規作成を行う
        binding.floatingActionButton.setOnClickListener {
            Log.d(TAG, "FAB listener clicked")
            mainActivityViewModel.createTask()
        }
        //画面の更新
        todoListFragmentViewModel.updateUI()
    }

}