package com.delegateadapters.base.model

import com.delegateadapters.delegate.diff.IComparableItem
import java.io.Serializable

class MoveViewModel(
    val fromPlace: String,
    var toPlace: String,
    var estimateTime: TimeInterval,
    val name: String
) : IComparableItem, Serializable {
    override fun name(): String {
        return  name
    }

    override fun id(): Any = fromPlace + toPlace
    override fun content(): Any = estimateTime

    enum class TimeInterval {
        SECOND, MINUTE, HOUR, DAY, WEEK, MONTH, YEAR, INFINITY
    }
}

