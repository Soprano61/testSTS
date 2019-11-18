package com.delegateadapters.base


import com.delegateadapters.base.DataUtils.currentDate
import com.delegateadapters.base.model.MoveViewModel
import com.delegateadapters.base.model.NoticeViewModel
import com.delegateadapters.delegate.diff.IComparableItem
import com.delegateadapters.base.model.EventViewModel
import java.util.*
import kotlin.properties.Delegates


internal object MockDataFactory {

    fun prepareData(): List<IComparableItem> {
        val SIZE = getRndCount(10, 100)
        val objects = ArrayList<IComparableItem>(SIZE)
        val random = Random()
        for (i in 0 until SIZE) {
            val item: IComparableItem
            val type = random.nextInt(3)
            when (type) {
                0 -> {
                    item = NoticeViewModel(currentDate, "Gate :" + i, "Notice")
                }
                1 -> {
                    item = EventViewModel(currentDate, currentDate, "Event")
                }
                else -> {
                    item = MoveViewModel("PointA", "PointB", MoveViewModel.TimeInterval.DAY, "Move")
                }
            }
            objects.add(item)
        }
        return objects
    }

    fun getRndCount(min: Int, max: Int): Int {
        var max = max
        max -= min
        return (Math.random() * ++max).toInt() + min
    }
}
