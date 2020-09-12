package tech.tokku_engineer.todoappsample_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoItemFragmentBinding
import tech.tokku_engineer.todoappsample_kotlin.viewmodels.TodoListFragmentViewModel

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
        var title: TextView = binding.title
        var item: TodoItem? = null

        init {
            binding.checkBox.setOnClickListener {
                item?.let { itemClickListener(it) }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemFragmentBinding.inflate(inflater, parent, false)
        return TodoItemViewHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val todoItem: TodoItem? = getItem(position)
        holder.title.text = todoItem?.title
        holder.title.setOnClickListener { itemClickListener }
    }

    override fun getItemId(position: Int): Long {
        return getItem(position)?.id ?: 0
    }

    fun update(todoList: List<TodoItem>) {

    }

    companion object {
        @JvmStatic
        @BindingAdapter("app:items")
        fun RecyclerView.bindItems(items: List<TodoItem>?) {
            if (items == null) {
                return
            } else {
                val adapter = adapter as TodoItemAdapter
                adapter.update(items)
            }
        }
    }
}