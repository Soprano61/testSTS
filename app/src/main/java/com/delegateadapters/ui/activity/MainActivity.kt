package com.delegateadapters.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.delegateadapters.R
import com.delegateadapters.base.MockDataFactory
import com.delegateadapters.ui.adapter.MoveDelegateAdapter
import com.delegateadapters.ui.adapter.EventDelegateAdapter
import com.delegateadapters.ui.adapter.NoticeDelegateAdapter
import com.delegateadapters.delegate.diff.DiffUtilCompositeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val diffAdapter  =
        DiffUtilCompositeAdapter.Builder()
            .add(NoticeDelegateAdapter(this))
            .add(MoveDelegateAdapter(this))
            .add(EventDelegateAdapter(this))
            .build()


    private fun generateNewData() {
        diffAdapter.swapData(MockDataFactory.prepareData())
        multiDetails.scrollToPosition(0)
        diffAdapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        multiDetails.run {
            layoutManager = LinearLayoutManager(context)
            adapter = diffAdapter
            generateNewData()
        }
        swipe.setOnRefreshListener {
            generateNewData()
            swipe.setRefreshing(false)
        }
    }
}
