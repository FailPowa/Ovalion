package com.example.florentin.ovalion

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.events.calendar.views.EventsCalendar
import kotlinx.android.synthetic.main.activity_calendar.*
import java.util.*
import kotlin.collections.ArrayList


class CalendarActivity : AppCompatActivity(), EventsCalendar.Callback {

    private var eventsDate = ArrayList<Calendar>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        var eventsCalendar = findViewById<EventsCalendar>(R.id.eventsCalendar)
        //set today's date [today: Calendar]
        val today = Calendar.getInstance()
        val end = Calendar.getInstance()
        end.add(Calendar.YEAR, 2)
        eventsCalendar.setMonthRange(today, end)
        eventsCalendar.setToday(today)
        //set current date and scrolls the calendar to the corresponding month of the selected date [today: Calendar]
        eventsCalendar.setCurrentSelectedDate(today)
        //set the callback for EventsCalendar
        eventsCalendar.setCallback(this)
        //set events on the EventsCalendar [c: Calendar]
        val c = Calendar.getInstance()
        c.add(Calendar.DAY_OF_MONTH, 2)
        eventsCalendar.addEvent(c)
        eventsDate.add(c)
        c.add(Calendar.DAY_OF_MONTH, 5)
        eventsCalendar.addEvent(c)
        eventsDate.add(c)

        // Configure action bar
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Hello Toolbar"


        // Initialize the action bar drawer toggle instance
        val drawerToggle:ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.drawer_open,
            R.string.drawer_close
        ) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }

        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        var navView = navigation_view.
        // Set navigation view navigation item selected listener
        navView.setNavigationItemSelectedListener{
            when (it.itemId){
               R.id.action_cut -> Toast.makeText(this, "Cut clicked", Toast.LENGTH_SHORT).show()
               R.id.action_copy -> Toast.makeText(this, "Copy clicked", Toast.LENGTH_SHORT).show()
               R.id.action_paste -> Toast.makeText(this, "Paste clicked", Toast.LENGTH_SHORT).show()
               R.id.action_new -> Toast.makeText(this, "New clicked", Toast.LENGTH_SHORT).show()
            }
            // Close the drawer
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onDayLongPressed(selectedDate: Calendar?) {
        Log.e("LONG", "CLICKED")
        if (selectedDate != null) {
            Toast.makeText(this, selectedDate.time.toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun onMonthChanged(monthStartDate: Calendar?) {
        Log.e("MON", "CHANGED")
    }

    override fun onDaySelected(selectedDate: Calendar?) {
        for (c: Calendar in eventsDate) {
            if (selectedDate != null) {
                val clickDate = "" + selectedDate.time.day + selectedDate.time.month + selectedDate.time.year
                val event = "" + c.time.day + c.time.month + c.time.year
                if(clickDate == event) {
                    Toast.makeText(this, c.time.toString(), Toast.LENGTH_LONG).show()
                } else {
                    Log.e("SHORT", "Click")
                }
            }
        }
    }

}