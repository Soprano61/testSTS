package com.delegateadapters.ui.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.delegateadapters.R
import com.delegateadapters.base.model.NoticeViewModel
import kotlinx.android.synthetic.main.fragment_notice_details.view.*

class NoticeDetailsFragment() : DialogFragment() {

    private lateinit var ok: Button
    private lateinit var title: TextView
    private lateinit var gate: TextView
    private lateinit var flightDate: TextView

     var listener: OnSelectedListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val myView = LayoutInflater.from(activity).inflate(R.layout.fragment_notice_details, null)
        val position = arguments?.getSerializable("test") as NoticeViewModel
        ok = myView.ok
        flightDate = myView.flightDate
        gate = myView.gate
        title = myView.title

        title.text = position.name
        gate.text = position.gate
        flightDate.text = position.flightDate.toString()

        ok.setOnClickListener {
            dialog?.dismiss()
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