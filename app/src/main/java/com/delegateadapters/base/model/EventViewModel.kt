package com.delegateadapters.base.model

import com.delegateadapters.delegate.diff.IComparableItem
import java.io.Serializable
import java.util.*

class EventViewModel(
    val startTime: Date,
    val endTime: Date,
    val name: String)
    : IComparableItem, Serializable {
    override fun id(): Any = name
    override fun content(): Any = startTime.toString() + " //--//" + endTime.toString()
    override fun name(): String {
        return name
    }
}
