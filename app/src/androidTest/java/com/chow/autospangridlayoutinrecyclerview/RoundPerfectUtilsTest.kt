package com.chow.autospangridlayoutinrecyclerview

import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RoundPerfectUtilsTest {
    @Test
    fun getScreenWidth() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertThat(appContext.resources.displayMetrics.widthPixels).isEqualTo(1080)
    }
}