package com.lbys.mvvmstarter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.lbys.mvvmstarter.databinding.ActivityMainBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()
        setupLeftNavigationDrawer()
    }

    private fun setupBottomNavigation() {
        val navController: NavController =
            Navigation.findNavController(this, R.id.navHostFragment)
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    private fun setupLeftNavigationDrawer() {
        val navController: NavController =
            Navigation.findNavController(this, R.id.navHostFragment)
        binding.myNavigationView.setupWithNavController(navController)
    }
}