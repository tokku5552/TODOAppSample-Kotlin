package tech.tokku_engineer.todoappsample_kotlin.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import tech.tokku_engineer.todoappsample_kotlin.R
import tech.tokku_engineer.todoappsample_kotlin.TodoItemAdapter
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoListFragmentBinding
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoListFragmentViewModel

class TodoListFragment : Fragment() {
    private lateinit var binding: TodoListFragmentBinding
    private val viewModel: TodoListFragmentViewModel =
        ViewModelProviders.of(this).get(TodoListFragmentViewModel::class.java)
    //private val listAdapter = TodoItemAdapter()


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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //  viewModel = ViewModelProviders.of(this).get(TodoListFragmentViewModel::class.java)

    }

}