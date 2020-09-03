package tech.tokku_engineer.todoappsample_kotlin.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tech.tokku_engineer.todoappsample_kotlin.R
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoItemDetailFragmentViewModel

class TodoItemDetailFragment : Fragment() {

    companion object {
        fun newInstance() = TodoItemDetailFragment()
    }

    private lateinit var viewModel: TodoItemDetailFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.todo_item_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TodoItemDetailFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}