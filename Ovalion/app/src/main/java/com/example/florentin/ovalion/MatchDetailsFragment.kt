package com.example.florentin.ovalion

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MatchDetailsFragment : Fragment() {

    companion object {
        fun newInstance(): MatchDetailsFragment {
            return MatchDetailsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_match_details, container, false)
    }
}