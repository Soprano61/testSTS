package com.delegateadapters.ui.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.delegateadapters.R
import com.delegateadapters.base.model.EventViewModel
import kotlinx.android.synthetic.main.fragment_event_details.view.*

class EventDetailsFragment() : DialogFragment() {

    private var ok: Button? = null
    private var title: TextView? = null
    private var startTime: TextView? = null
    private var endTime: TextView? = null
    private var name: TextView? = null


    var listener: OnSelectedListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val myView = LayoutInflater.from(activity).inflate(R.layout.fragment_event_details, null)
        val position = arguments?.getSerializable("test") as EventViewModel
        ok = myView.ok
        startTime = myView.startTime
        endTime = myView.endTime
        title = myView.title
        name = myView.name

        title?.text = position.name
        startTime?.text = position.startTime.toString()
        endTime?.text = position.endTime.toString()
        name?.text = position.name

        ok?.setOnClickListener {
            dialog.dismiss()
            onSelected()
        }

        return AlertDialog.Builder(activity, R.style.ThemeOverlay_AppCompat_Dialog_Alert)
            .setView(myView)
            .create()
    }

    private fun onSelected() {
        listener?.onSelected()
        dismiss()
    }

    interface OnSelectedListener {
        fun onSelected()
    }
}