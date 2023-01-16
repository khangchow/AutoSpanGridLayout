package com.chow.autospangridlayoutinrecyclerview

object RoundUtils {
    fun Int.roundMaxPerfect() = when {
        this.getTotalNum() == 1 -> if (this <= 5) 5 else 10
        this == this.roundDown() -> this.roundDown()
        this < this.roundToOneHalf() -> this.roundToOneHalf()
        this > this.roundToOneHalf() -> this.roundDown() * 2
        else -> this.roundToOneHalf()
    }

    fun Int.roundMinPerfect() = when {
        this.getTotalNum() == 1 -> if (this <= 5) 5 else 10
        this == this.roundDown() -> this.roundDown()
        this > this.roundUp() / 2 -> this.roundUp()
        this <= this.roundUp() / 2 -> this.roundUp() / 2
        else -> -1
    }

    private fun Int.getTotalNum() = this.toString().length

    private fun Int.getFirstDigit() = this.toString()[0].digitToInt()

    private fun Int.roundDown(): Int {
        var result = this.getFirstDigit()
        for (i in 1 until this.getTotalNum()) {
           result *= 10
        }
        return result
    }

    private fun Int.roundToOneHalf() = this.roundDown() + (this.roundDown() / 2)

    private fun Int.roundUp(): Int {
        var result = 1
        for (i in 1..this.getTotalNum()) {
            result *= 10
        }
        return result
    }
}