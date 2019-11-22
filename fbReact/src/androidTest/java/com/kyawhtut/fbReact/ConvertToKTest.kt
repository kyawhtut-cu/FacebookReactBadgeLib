package com.kyawhtut.fbReact

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.text.DecimalFormat
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

@RunWith(AndroidJUnit4::class)
class ConvertToKTest {

    private fun convertToK(number: Int): String {
        val suffix = charArrayOf(' ', 'K', 'M', 'B', 'T', 'P', 'E')
        return with(floor(log10(number.toDouble())).toInt()) {
            val base: Int = this / 3
            if (this >= 3 && base < suffix.size) {
                DecimalFormat("#0.0").format(
                    number / 10.0.pow(base * 3)
                ) + suffix[base]
            } else DecimalFormat("#,##0").format(number)
        }
    }

    @Test
    fun numberTest() {
        Assert.assertEquals("789", convertToK(789))
        Assert.assertEquals("5.8K", convertToK(5821))
        Assert.assertEquals("101.8K", convertToK(101808))
        Assert.assertEquals("7.9M", convertToK(7898562))
    }
}