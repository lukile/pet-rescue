package com.example.petrescue

import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(){
    private lateinit var drawer: DrawerLayout
    private lateinit var actionBar: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        actionBar = ActionBarDrawerToggle(this, drawer, toolbar, R.string.appName, R.string.appName)
        drawer.addDrawerListener(actionBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { item ->
            item.isChecked = true
            drawer.closeDrawers()

            when(item.itemId) {
                R.id.nav_profile -> {
                    Toast.makeText(this, "Profil", Toast.LENGTH_LONG).show()
                }
                R.id.nav_commercials -> {
                    Toast.makeText(this, "Annonces", Toast.LENGTH_LONG).show()
                }
                R.id.nav_post -> {
                    Toast.makeText(this, "Poster une annonce", Toast.LENGTH_LONG).show()
                }
            }
            true
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        actionBar.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        actionBar.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (actionBar.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
