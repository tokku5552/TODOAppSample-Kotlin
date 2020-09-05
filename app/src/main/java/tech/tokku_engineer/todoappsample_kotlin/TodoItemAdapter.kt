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

class TodoItemAdapter(data: OrderedRealmCollection<TodoItem>) :
    RealmRecyclerViewAdapter<TodoItem, TodoItemAdapter.TodoItemViewHolder>(data, true) {

    init {
        setHasStableIds(true)
    }

    // セルに使用するビューを保持するためのもの
    class TodoItemViewHolder(
        binding: TodoItemFragmentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        val title: TextView = binding.title
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = TodoItemFragmentBinding.inflate(inflater, parent, false)
        return TodoItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}