package com.delegateadapters.ui.adapter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.delegateadapters.R
import com.delegateadapters.base.DataUtils.getDate
import com.delegateadapters.base.model.NoticeViewModel
import com.delegateadapters.delegate.KDelegateAdapter
import com.delegateadapters.ui.fragment.NoticeDetailsFragment
import kotlinx.android.synthetic.main.list_item.*
import android.os.Bundle



class NoticeDelegateAdapter(private  val context : Context) : KDelegateAdapter<NoticeViewModel>() {

    override fun onBind(item: NoticeViewModel, viewHolder: KViewHolder) =
            with(viewHolder) {
                names.text =  item.name
                itemTxtOne.text = item.gate
                itemTxtTwo.text = getDate(0)
                layoutFold.setOnClickListener {
                    val dlg = NoticeDetailsFragment()
                    val bundle = Bundle()
                    bundle.putSerializable("test", item)
                    dlg.setArguments(bundle)
                    val manager = (context as AppCompatActivity).supportFragmentManager
                    dlg.show(manager,"dlg")
                }
            }

    override fun isForViewType(items: List<*>, position: Int) =
            items[position] is NoticeViewModel

    override fun getLayoutId(): Int = R.layout.list_item
}