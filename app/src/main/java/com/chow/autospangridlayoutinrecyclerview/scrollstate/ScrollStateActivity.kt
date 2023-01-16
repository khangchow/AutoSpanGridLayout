package com.chow.autospangridlayoutinrecyclerview.scrollstate

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chow.autospangridlayoutinrecyclerview.databinding.ActivityMainBinding

class ScrollStateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ScrollStateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[ScrollStateViewModel::class.java]
        setContentView(binding.root)
        binding.run {
            viewModel.list.observe(this@ScrollStateActivity) {
                srl.isRefreshing = false
                (binding.rvContent.adapter as ScrollStateAdapter).updateList(it)
            }
            rvContent.apply {
                adapter = ScrollStateAdapter()
                layoutManager = LinearLayoutManager(this@ScrollStateActivity)
            }
            srl.setOnRefreshListener(viewModel::refreshData)
        }
        viewModel.showData()
    }

    override fun onDestroy() {
        viewModel.updateListOnDestroy(getScrollStates())
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        viewModel.saveListState(getScrollStates())
        super.onSaveInstanceState(outState)
    }

    private fun getScrollStates() = (binding.rvContent.adapter as ScrollStateAdapter).getScrollStates()
}