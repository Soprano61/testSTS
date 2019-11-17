package com.delegateadapters.ui.adapter

import android.content.Context
import android.os.Bundle
import com.delegateadapters.base.model.EventViewModel
import com.delegateadapters.delegate.KDelegateAdapter
import kotlinx.android.synthetic.main.list_item.*
import androidx.appcompat.app.AppCompatActivity
import com.delegateadapters.R
import com.delegateadapters.ui.fragment.EventDetailsFragment


class EventDelegateAdapter(private  val context :Context)
    : KDelegateAdapter<EventViewModel>() {

    override fun onBind(item: EventViewModel, viewHolder: KViewHolder) =
            with(viewHolder) {
                names.text = item.name
                itemTxtOne.text = item.content().toString()
                layoutFold.setOnClickListener {
                    val dlg = EventDetailsFragment()
                    val bundle = Bundle()
                    bundle.putSerializable("test", item)
                    dlg.setArguments(bundle)
                    val manager = (context as AppCompatActivity).supportFragmentManager
                    dlg.show(manager,"dlg")
                }
            }

    override fun isForViewType(items: List<*>, position: Int) =
            items[position] is EventViewModel

    override fun getLayoutId(): Int = R.layout.list_item
}