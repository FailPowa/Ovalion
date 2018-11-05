package com.example.florentin.dao.ovalion

import android.util.Log
import java.util.*
import kotlin.collections.ArrayList

class Match {
    private lateinit var teamIn : Team
    private lateinit var teamOut : Team
    private lateinit var date : Date
    private var score_1 : Int = 0
    private var score_2 : Int = 0

    fun init(team1 : Team?, team2 : Team?, date : Date?, score1 : Int?, score2 : Int?) : Match{
        if(team1 != null && team2 != null && date != null) {
            this.teamIn = team1
            this.teamOut = team2
            this.date = date

            if(date < Calendar.getInstance().time) {
                if(score1 != null && score2 != null) {
                    this.score_1 = score1
                    this.score_2 = score2
                }
            }
        }
        return this
    }

    fun getTeams() : ArrayList<Team> {
        var res = ArrayList<Team>()
        res.add(this.teamIn)
        res.add(this.teamOut)
        return res
    }

    fun getScores() : ArrayList<Int> {
        var res = ArrayList<Int>()
        res.add(this.score_1)
        res.add(this.score_2)
        return res
    }

    fun getDate() : Date {
        return this.date
    }

    fun setScores(score1: Int?, score2: Int?) : Boolean {
        if(score1 != null && score2 != null) {
            this.score_1 = score1
            this.score_2 = score2
            return true
        }
        Log.d("Error Match Object", "Int attendu en paramètres de la fonction Match.setScores()")
        return false
    }

    fun setDate(date: Date?) : Boolean {
        if(date != null) {
            this.date = date
            return true
        }
        Log.d("Error Match Object", "Date attendu en paramètres de la fonction setDate()")
        return false
    }
}