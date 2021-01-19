package com.rba.tennis

import com.rba.tennis.utils.Constant
import com.rba.tennis.utils.Utils
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class UtilTest {

    @Test
    fun validateNumberPlayers() {
        assertEquals(Constant.SIZE_PLAYERS, Utils.createPlayers().size)
    }

    @Test
    fun validatePlayerOne() {
        assertEquals("Player 1", Utils.createPlayers()[0].name)
    }

}