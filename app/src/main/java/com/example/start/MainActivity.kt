package com.example.start

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.start.databinding.ActivityMainBinding
import com.example.task.TaskVMFactory
import com.example.task.TaskViewModel
import com.example.timer.ActiveTimer
import com.example.timer.DestroyTimer
import com.example.timer.MainTimer
import kotlinx.android.synthetic.main.fragment_start.*
import timber.log.Timber


private const val TEXT_INPUT = "text_input"
private const val TEXT_INPUT2 = "text_input2"

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration : AppBarConfiguration
    private  lateinit var timerActive: MainTimer
    private  lateinit var timerToDestroy: MainTimer
    private var counter = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("OnCreate Called")

        timerActive = ActiveTimer(this.lifecycle)
        timerToDestroy = DestroyTimer(this.lifecycle)


        if(savedInstanceState != null){
            textInput.setText(savedInstanceState.getString(TEXT_INPUT))
        }

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        drawerLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        // prevent nav gesture if not on start destination
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
            if (nd.id == nc.graph.startDestination) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            } else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
        }
        NavigationUI.setupWithNavController(binding.navView, navController)

    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_INPUT, textInput.text.toString())
        outState.putString(TEXT_INPUT2, textInput.text.toString())
        Timber.i("onSaveInstanceState Called")
    }

    override fun onStart() {
        super.onStart()
        Timber.i("OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("OnResume Called")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("OnPause Called")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("OnStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("OnDestroy Called")
        var percent = timerActive.secondsCount.toDouble()/timerToDestroy.secondsCount.toDouble() * 100
        Timber.i("Time from onStart to onDestroy is : ${timerActive.secondsCount}/${timerToDestroy.secondsCount} seconds : $percent %")
    }
}