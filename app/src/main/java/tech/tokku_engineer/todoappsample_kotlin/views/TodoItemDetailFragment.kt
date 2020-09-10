package tech.tokku_engineer.todoappsample_kotlin.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import tech.tokku_engineer.todoappsample_kotlin.R
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoItemDetailFragmentBinding
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoListFragmentBinding
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoItemDetailFragmentViewModel
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoListFragmentViewModel

private const val TAG = "TodoItemDetailFragment"

class TodoItemDetailFragment : Fragment() {
    private lateinit var binding: TodoItemDetailFragmentBinding
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

    }

}