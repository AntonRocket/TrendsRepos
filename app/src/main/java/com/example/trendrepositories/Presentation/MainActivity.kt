package com.example.trendrepositories.Presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trendrepositories.R

class MainActivity : AppCompatActivity() {

    private lateinit var reposAdapter: ReposAdapter

    private lateinit var tvTrend: TextView

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setGoWebClickListener()
        tvTrend = findViewById(R.id.tv_filter)
    }

    private fun setupRecyclerView() {
        findViewById<RecyclerView>(R.id.rv_repository_list).also { rv ->
            reposAdapter = ReposAdapter()
            viewModel.repositoriesLiveData.observe(this) {
                reposAdapter.submitList(it)
                rv.smoothScrollToPosition(0)
            }
            rv.adapter = reposAdapter
            rv.layoutManager = LinearLayoutManager(baseContext)
        }
        viewModel.trendLiveData.observe(this) {
            tvTrend.text = baseContext.getString(it.titleId)
        }
    }

    private fun setGoWebClickListener() {
        reposAdapter.onRepositoryClickListener = {
            viewModel.requestRouter(it.url)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        viewModel.requestRepositories(id)
        return true
    }
}
