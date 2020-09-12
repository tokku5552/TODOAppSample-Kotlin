package tech.tokku_engineer.todoappsample_kotlin

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmRecyclerViewAdapter
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoItemFragmentBinding
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoListFragmentViewModel

private const val TAG = "TodoItemAdapter"

class TodoItemAdapter(
    viewModel: TodoListFragmentViewModel,
    private val itemClickListener: (TodoItem) -> Unit
) :
    RealmRecyclerViewAdapter<TodoItem, TodoItemAdapter.TodoItemViewHolder>(viewModel.data, true) {

    init {
        setHasStableIds(true)
    }

    // ビューを保持するためのもの
    class TodoItemViewHolder(
        binding: TodoItemFragmentBinding,
        itemClickListener: (TodoItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        private var mBinding: TodoItemFragmentBinding
        var title: TextView = binding.title
        var item: TodoItem? = null

        init {
            binding.checkBox.setOnClickListener {
                item?.let { itemClickListener(it) }
            }
            mBinding = binding
        }

        fun bindTo(todoItem: TodoItem) {
            Log.d(TAG, "called bindTo")
            mBinding.title.text = todoItem.title
            mBinding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoItemViewHolder {
        Log.d(TAG, "called onCreateViewHolder")
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemFragmentBinding.inflate(inflater, parent, false)
        return TodoItemViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        Log.d(TAG, "called onBindViewHolder")
        val todoItem: TodoItem? = getItem(position)
        if (todoItem != null) {
            holder.bindTo(todoItem)
        }
    }

    override fun getItemId(position: Int): Long {
        return getItem(position)?.id ?: 0
    }


}