package com.gunder.academy.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gunder.academy.data.ModuleEntity
import com.gunder.academy.databinding.ItemsModuleListBinding

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ModulViewHolder>() {
    inner class ModulViewHolder(private val binding: ItemsModuleListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(module: ModuleEntity) {
            binding.textModuleTitle.text = module.title
        }
    }

    private val listModules = ArrayList<ModuleEntity>()

    fun setModules(modules: List<ModuleEntity>) {
        this.listModules.clear()
        this.listModules.addAll(modules)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): DetailCourseAdapter.ModulViewHolder {
        val itemModuleListBinding =
            ItemsModuleListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModulViewHolder(itemModuleListBinding)
    }

    override fun onBindViewHolder(holder: DetailCourseAdapter.ModulViewHolder, position: Int) {
        val module = listModules[position]
        holder.bind(module)
    }

    override fun getItemCount(): Int = listModules.size
}