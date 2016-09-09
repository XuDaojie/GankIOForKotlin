package io.github.xudaojie.gankioforkotlin.common

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by xdj on 16/9/9.
 */

object TimeUtils {

    fun format(date: Date, pattern: String): String {
        val dateFormat = SimpleDateFormat(pattern, Locale.CHINA)
        return dateFormat.format(date)
    }

    fun parse(dateStr: String, pattern: String): Date {
        val dateFormat = SimpleDateFormat(pattern, Locale.CHINA)
        return dateFormat.parse(dateStr)
    }
}
