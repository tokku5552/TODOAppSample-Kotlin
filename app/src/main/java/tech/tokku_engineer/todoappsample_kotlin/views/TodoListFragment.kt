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

    // TodoItemがクリックされた時のリスナー
    private val itemClickListener = { todoItem: TodoItem ->
        mainActivityViewModel.todoItemClicked(todoItem)
    }

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
     * ActivityCreatedでオブザーブの処理を行う
     */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "called onActivityCreated")

        binding.list.adapter =
            TodoItemAdapter(todoListFragmentViewModel, itemClickListener)

        binding.floatingActionButton.setOnClickListener {
            Log.d(TAG, "FAB listener clicked")
            mainActivityViewModel.createTask()
        }

        //一覧画面でアイテムがクリックされた時

        //画面の更新
        todoListFragmentViewModel.updateUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        //realm.close()
    }

}