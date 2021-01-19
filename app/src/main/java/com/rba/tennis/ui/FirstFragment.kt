package com.rba.tennis.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.rba.tennis.R
import com.rba.tennis.model.Player
import com.rba.tennis.utils.Utils

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var players = mutableListOf<Player>()
    private lateinit var winnerTextView: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        winnerTextView = view.findViewById(R.id.winner_player)

        view.findViewById<Button>(R.id.button_simulate).setOnClickListener {
            players.clear()
            winnerTextView.text = ""
            players = Utils.createPlayers()
            simulate()
        }
    }


    private fun simulate() {
        var winners = players

        do {
            winners = round(winners)
        } while (winners.size > 1)

        if (winners.size == 1) {
            winnerTextView.text = getString(R.string.winner, winners[0].name, winners[0].skill.toString())
        }

    }

    private fun round(players: MutableList<Player>): MutableList<Player> {
        players.shuffle()

        val size = players.size / 2

        val teamA = mutableListOf<Player>()
        val teamB = mutableListOf<Player>()
        val winners = mutableListOf<Player>()

        for (i in 0 until size) {
            teamA.add(players[i])
        }

        for (i in size - 1 until players.size) {
            teamB.add(players[i])
        }

        teamA.forEachIndexed { index, player ->
            winners.add(winner(player, teamB[index]))
        }
        return winners
    }

    private fun winner(player1: Player, player2: Player): Player {

        val probability1: Double = player1.skill * Utils.lucky() / 100.0
        val probability2: Double = player2.skill * Utils.lucky() / 100.0

        return if (probability1 > probability2) {
            player1
        } else {
            player2
        }
    }

}