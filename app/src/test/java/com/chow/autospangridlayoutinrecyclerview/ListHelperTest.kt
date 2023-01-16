package com.chow.autospangridlayoutinrecyclerview

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ListHelperTest {
    @Test
    fun test() {
        val list = ListHelper.createListNumber(3)
        assertThat(list).isEqualTo(listOf("1", "2", "3"))
    }
}