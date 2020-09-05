package tech.tokku_engineer.todoappsample_kotlin.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tech.tokku_engineer.todoappsample_kotlin.R
import tech.tokku_engineer.todoappsample_kotlin.TodoItemAdapter
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoListFragmentBinding
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoListFragmentViewModel

class TodoListFragment : Fragment() {
    private lateinit var todoListFragmentViewModel: TodoListFragmentViewModel
    private lateinit var binding: TodoListFragmentBinding

    //private val listAdapter = TodoItemAdapter()


    companion object {
        fun newInstance() = TodoListFragment()
    }

    private lateinit var viewModel: TodoListFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TodoListFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}