package tech.tokku_engineer.todoappsample_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import tech.tokku_engineer.todoappsample_kotlin.models.TodoItem
import tech.tokku_engineer.todoappsample_kotlin.databinding.TodoItemFragmentBinding

class TodoItemAdapter(
    data: OrderedRealmCollection<TodoItem>,
    private val itemClickListener: (TodoItem) -> Unit
) :
    RealmRecyclerViewAdapter<TodoItem, TodoItemAdapter.TodoItemViewHolder>(data, true) {

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

}