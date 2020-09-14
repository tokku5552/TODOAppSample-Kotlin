package tech.tokku_engineer.todoappsample_kotlin.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.*
import tech.tokku_engineer.todoappsample_kotlin.R
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoItemDetailFragmentBinding
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.utils.toDate
import tech.tokku_engineer.todoappsample_kotlin.utils.toString
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.MainActivityViewModel
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoItemDetailFragmentViewModel

private const val TAG = "TodoItemDetailFragment"

class TodoItemDetailFragment : Fragment() {
    private lateinit var binding: TodoItemDetailFragmentBinding
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()
    private val todoItemDetailFragmentViewModel: TodoItemDetailFragmentViewModel by viewModels()

    companion object {
        fun newInstance() = TodoItemDetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "called onCreateView")
        val view = inflater.inflate(R.layout.todo_item_detail_fragment, container, false)
        binding = TodoItemDetailFragmentBinding.bind(view).apply {
            viewmodel = todoItemDetailFragmentViewModel
        }
        binding.lifecycleOwner = this.viewLifecycleOwner
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(TAG, "called onActivityCreated")
        //戻るボタンは共通なので先にセットする
        binding.buttonRight.setOnClickListener {
            closeFragment()
        }
        //mainActivityViewModelのselectedItemがnullだったら新規作成画面
        //値がセットされていたら各値をセットする
        val selectedItem = mainActivityViewModel.selectedItem
        if (selectedItem == null) {
            showNewTask()
        } else {
            showTask(selectedItem)
        }
    }

    private fun closeFragment() {
        val mainActivity = activity
        if (mainActivity != null) {
            mainActivity.supportFragmentManager.popBackStack()
        } else {
            mainActivityViewModel.createTask()
        }
    }

    //新規作成画面の表示
    private fun showNewTask() {
        binding.buttonLeft.setOnClickListener {
            todoItemDetailFragmentViewModel.createNewTask(
                binding.editTitle.text.toString(),
                binding.editDetail.text.toString()
            )
            closeFragment()
        }
    }

    //詳細画面の表示
    private fun showTask(todoItem: TodoItem) {
        binding.editTitle.setText(todoItem.title, TextView.BufferType.EDITABLE)
        binding.editDetail.setText(todoItem.detail, TextView.BufferType.EDITABLE)
        binding.editCreate.text = todoItem.createDate.toString("yyyy/MM/dd")
        binding.createDate.isVisible = true
        binding.editCreate.isVisible = true
        if (todoItem.createDate != todoItem.updateDate) {
            binding.editUpdate.text = todoItem.updateDate.toString("yyyy/MM/dd")
            binding.editUpdate.isVisible = true
            binding.update.isVisible = true
        }
        binding.buttonLeft.text = "更新"
        binding.buttonLeft.setOnClickListener {
            todoItemDetailFragmentViewModel.updateTask(
                todoItem.id,
                binding.editTitle.text.toString(),
                binding.editDetail.text.toString()
            )
            closeFragment()
        }

    }
}