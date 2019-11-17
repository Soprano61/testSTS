package com.delegateadapters.ui.adapter

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.delegateadapters.R
import com.delegateadapters.base.model.MoveViewModel
import com.delegateadapters.delegate.KDelegateAdapter
import com.delegateadapters.ui.fragment.MoveDetailsFragment
import kotlinx.android.synthetic.main.list_item.*

class MoveDelegateAdapter(private  val context : Context) : KDelegateAdapter<MoveViewModel>() {
    
    override fun onBind(item: MoveViewModel, viewHolder: KViewHolder) =
            with(viewHolder) {
                names.text = item.name
                itemTxtOne.text = item.fromPlace +"-"+ item.toPlace
                itemTxtTwo.text =  item.estimateTime.toString()
                layoutFold.setOnClickListener {
                    val dlg = MoveDetailsFragment()
                    val bundle = Bundle()
                    bundle.putSerializable("test", item)
                    dlg.setArguments(bundle)
                    val manager = (context as AppCompatActivity).supportFragmentManager
                    dlg.show(manager,"dlg")
                }
            }

    override fun isForViewType(items: List<*>, position: Int) =
            items[position] is MoveViewModel

    override fun getLayoutId(): Int = R.layout.list_item
}