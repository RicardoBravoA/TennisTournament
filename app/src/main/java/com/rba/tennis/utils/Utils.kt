package com.rba.tennis.utils

import com.rba.tennis.model.Player
import kotlin.random.Random

object Utils {

    //return player skill between 0 and 100
    private fun skill(): Int {
        return Random.nextInt(0, 100)
    }

    //return player lucky between 0 and 100 for win or lose the match
    fun lucky(): Int {
        return Random.nextInt(0, 100)
    }

    // create players
    fun createPlayers(): MutableList<Player> {
        val players = mutableListOf<Player>()
        for (i in 1..Constant.SIZE_PLAYERS) {
            val player = Player("Player $i", skill())
            players.add(player)
        }
        return players
    }

}