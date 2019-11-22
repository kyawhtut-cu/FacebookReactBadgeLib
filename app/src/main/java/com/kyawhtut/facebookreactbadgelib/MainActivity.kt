package com.kyawhtut.facebookreactbadgelib

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.kyawhtut.fbReact.Emoji
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        reactBadge.react = Emoji.getReactType("Angry")
        sp_reaction_type.adapter = ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1,
            arrayListOf("Like", "Love", "Haha", "Wow", "Sad", "Angry")
        )
        sp_reaction_type.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                reactBadge.apply {
                    clear()
                    react = Emoji.getReactType(sp_reaction_type.selectedItem as String)
                    reactCount = 1
                }
            }
        }

        btn_increase.setOnClickListener {
            reactBadge.reactCount += 1
        }

        btn_clear.setOnClickListener {
            reactBadge.reactCount = 0
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
