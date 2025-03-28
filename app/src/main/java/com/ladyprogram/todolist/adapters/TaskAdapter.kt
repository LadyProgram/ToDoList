package com.ladyprogram.todolist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ladyprogram.todolist.data.Task
import com.ladyprogram.todolist.databinding.ItemTaskBinding


class TaskAdapter(var items: List<Task>, val onClick: (Int) -> Unit) : RecyclerView.Adapter<TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size
    //{ return items.size }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = items[position]
        holder.render(task)
        holder.itemView.setOnClickListener {
            onClick(position)
        }
    }

    fun updateItems(items: List<Task>) {
        this.items = items
        notifyDataSetChanged()
    }

}


class TaskViewHolder(val binding: ItemTaskBinding) : ViewHolder(binding.root) {

    //val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    //val pictureImageView: ImageView = view.findViewById(R.id.pictureImageView)

    fun render(task: Task) {
        binding.titleTextView.text = task.title
        binding.doneCheckBox.isChecked = task.done
    }

}