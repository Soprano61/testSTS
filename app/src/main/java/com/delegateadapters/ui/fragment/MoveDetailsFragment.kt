package com.delegateadapters.ui.fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.delegateadapters.R
import com.delegateadapters.base.model.MoveViewModel
import kotlinx.android.synthetic.main.fragment_move_details.view.*

class MoveDetailsFragment() : DialogFragment() {

    private lateinit var ok: Button
    private lateinit var title: TextView
    private lateinit var fromPlace: TextView
    private lateinit var toPlace: TextView
    private lateinit var estimateTime: TextView

     var listener: OnSelectedListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val myView = LayoutInflater.from(activity).inflate(R.layout.fragment_move_details, null)
        val position = arguments?.getSerializable("test") as MoveViewModel
        ok = myView.ok
        fromPlace = myView.fromPlace
        toPlace = myView.toPlace
        estimateTime = myView.estimateTime
        title = myView.title

        title.text = position.name
        fromPlace.text = position.fromPlace
        toPlace.text = position.toPlace
        estimateTime.text = position.estimateTime.toString()

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