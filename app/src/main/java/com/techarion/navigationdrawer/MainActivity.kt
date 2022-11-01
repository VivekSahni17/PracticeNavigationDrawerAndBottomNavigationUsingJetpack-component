package com.techarion.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.*

import com.google.android.material.navigation.NavigationView
import com.techarion.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

   lateinit var binding:ActivityMainBinding
//    private lateinit var navigationView:NavigationView

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfig: AppBarConfiguration
    private lateinit var navController: NavController

//    private val navController by lazy {
//        Navigation.findNavController(this, R.id.nav_host_fragment)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        navController = NavController(this)



       binding.navView.setupWithNavController(navController)
       binding.bottomNav.setupWithNavController(navController)

        drawerLayout = binding.drawerLayout
        navController = this.findNavController(R.id.navHostFragment)

        binding.bottomNav.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        appBarConfig = AppBarConfiguration.Builder(R.id.homeFragment, R.id.categoryFragment, R.id.profileFragment)
        .setDrawerLayout(drawerLayout)
        .build()
         setupActionBarWithNavController(navController, appBarConfig)



        navController.addOnDestinationChangedListener { nav_cont, destination, _ ->

        if(destination.id == nav_cont.graph.startDestinationId){
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        }
        else{
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }
    }

    NavigationUI.setupWithNavController(binding.navView, navController)
}

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfig)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }




//        navigationView = NavigationView(this)
//
//        setupDrawerLayout()
    }


//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navController, binding.drawerLayout)
//    }
//
//    private fun setupDrawerLayout() {
//        navigationView.setupWithNavController(navController)
//        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
//    }
//
//    override fun onBackPressed() {
//        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            binding.drawerLayout.closeDrawer(GravityCompat.START)
//        } else {
//            super.onBackPressed()
//        }
//    }
