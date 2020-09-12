package tech.tokku_engineer.todoappsample_kotlin.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import tech.tokku_engineer.todoappsample_kotlin.R
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoItemDetailFragmentBinding
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

        binding.buttonLeft.setOnClickListener {
            todoItemDetailFragmentViewModel.createNewTask(
                binding.editTitle.text.toString(),
                binding.editDetail.text.toString()
            )
            closeFragment()
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

}