package com.chow.autospangridlayoutinrecyclerview

import com.chow.autospangridlayoutinrecyclerview.RoundUtils.roundMaxPerfect
import com.chow.autospangridlayoutinrecyclerview.RoundUtils.roundMinPerfect
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RoundUtilsTest {
    //Max
    @Test
    fun `recalculate max width equal round down`() {
        val max = 1000
        assertThat(max.roundMaxPerfect()).isEqualTo(1000)
    }

    @Test
    fun `recalculate max width equal 1 half value`() {
        val max = 1500
        assertThat(max.roundMaxPerfect()).isEqualTo(1500)
    }

    @Test
    fun `recalculate max width smaller than 1 half value`() {
        val max = 1242
        assertThat(max.roundMaxPerfect()).isEqualTo(1500)
    }

    @Test
    fun `recalculate max width bigger 1 half value`() {
        val max = 1678
        assertThat(max.roundMaxPerfect()).isEqualTo(2000)
    }

    @Test
    fun `recalculate max width with 1 number smaller than 5`() {
        val max = 2
        assertThat(max.roundMaxPerfect()).isEqualTo(5)
    }

    @Test
    fun `recalculate max width with 1 number bigger than 5`() {
        val max = 7
        assertThat(max.roundMaxPerfect()).isEqualTo(10)
    }
    @Test
    fun `recalculate max width with 1 number equal 5`() {
        val max = 5
        assertThat(max.roundMaxPerfect()).isEqualTo(5)
    }

    //Min
    @Test
    fun `recalculate min width equal round down`() {
        val min = 1000
        assertThat(min.roundMinPerfect()).isEqualTo(1000)
    }

    @Test
    fun `recalculate min width bigger than 1 half value`() {
        val min = 721
        assertThat(min.roundMinPerfect()).isEqualTo(1000)
    }

    @Test
    fun `recalculate min width smaller than 1 half value`() {
        val min = 250
        assertThat(min.roundMinPerfect()).isEqualTo(500)
    }

    @Test
    fun `recalculate min width equal 1 half value`() {
        val min = 500
        assertThat(min.roundMinPerfect()).isEqualTo(500)
    }

    @Test
    fun `recalculate min width with 1 number smaller than 5`() {
        val min = 2
        assertThat(min.roundMinPerfect()).isEqualTo(5)
    }

    @Test
    fun `recalculate min width with 1 number bigger than 5`() {
        val min = 7
        assertThat(min.roundMinPerfect()).isEqualTo(10)
    }
    @Test
    fun `recalculate min width with 1 number equal 5`() {
        val min = 5
        assertThat(min.roundMinPerfect()).isEqualTo(5)
    }

}