package com.example.florentin.dao.ovalion

import android.media.Image

class Team() {

    private lateinit var logo: Image
    private lateinit var name : String
    private lateinit var match_played : ArrayList<Match>
    private lateinit var matches : ArrayList<Match>
    private lateinit var location : String

    fun init(name: String?, logo: Image?, matches: ArrayList<Match>?) : Team {
        if(name != null && logo != null) {
            this.name = name
            this.logo = logo
        }

        if(matches != null)
            for(m in matches)
                this.matches.add(m)

        return this
    }

    fun getName() : String {
        return this.name
    }

    fun getLogo() : Image {
        return this.logo
    }

    fun setName(name: String?) : Boolean {
        if(name != null) {
            this.name = name
            return true
        }
        return false
    }

    fun getLocation() : String {
        return this.location
    }

    fun setLocation(loc : String?) : Boolean {
        if(loc != null) {
            this.location = loc
            return true
        }
        return false
    }

    fun setLogo(img : Image?) : Boolean {
        if(img != null) {
            this.logo = img
            return true
        }
        return false
    }
}