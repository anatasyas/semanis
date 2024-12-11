package com.example.simanisapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.simanisapp.databinding.ActivityDashboardBinding
import com.example.simanisapp.ui.artikel.ArtikelFragment
import com.example.simanisapp.ui.dashboard.DashboardFragment
import com.example.simanisapp.ui.input.InputFragment
import com.example.simanisapp.ui.notifications.NotificationsFragment
import com.example.simanisapp.ui.report.ReportFragment
import com.example.simanisapp.ui.setting.SettingFragment
import com.google.android.material.bottomnavigation.BottomNavigationView



class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(DashboardFragment())


        val bottomNavigationView: BottomNavigationView = binding.navView
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_dashboard -> {
                    loadFragment(DashboardFragment())
                    true
                }
                R.id.navigation_notifications -> {
                    loadFragment(NotificationsFragment())
                    true
                }
                R.id.navigation_input -> {
                    loadFragment(InputFragment())
                    true
                }
                R.id.navigation_report -> {
                    loadFragment(ReportFragment())
                    true
                }
                R.id.navigation_setting -> {
                    loadFragment(SettingFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
