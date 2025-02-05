package com.example.carsales

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.carsales.ui.carlist.CarListFragment
import com.example.carsales.ui.profile.ProfileFragment
import com.example.carsales.ui.compare.CompareCarsFragment
import com.example.carsales.ui.loan.LoanCalculatorFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    loadFragment(CarListFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_compare -> {
                    loadFragment(CompareCarsFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_loan -> {
                    loadFragment(LoanCalculatorFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_profile -> {
                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        // Load the default fragment
        loadFragment(CarListFragment())
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}