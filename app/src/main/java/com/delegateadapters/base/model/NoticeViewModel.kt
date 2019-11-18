package com.delegateadapters.base.model

import com.delegateadapters.delegate.diff.IComparableItem
import java.io.Serializable
import java.util.*


class NoticeViewModel(val flightDate: Date, val gate: String, val name: String) : IComparableItem,
    Serializable {

    override fun id(): Any {
        return flightDate
    }

    override fun content(): Any {
        return gate
    }

    override fun name(): String {
        return name
    }
}
