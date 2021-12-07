package ru.harrier55.project.filmography.ui

/**
 *
 * */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import ru.harrier55.project.filmography.R
import ru.harrier55.project.filmography.data.CardFilmEntity
import ru.harrier55.project.filmography.data.MyApp
import ru.harrier55.project.filmography.data.WebConnection

class MainActivity : AppCompatActivity() {

    private val TAG:String = "@@@"

    private lateinit var bottomNavigation: BottomNavigationView
    private var filmListFragment: FilmListFragment = FilmListFragment()
    private var favoritFragment: FavoritFragment = FavoritFragment()
    private var ratingsFragment: RatingsFragment = RatingsFragment()
    private var cardFilm = CardFilmEntity()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: start MainActivity")
        (applicationContext as MyApp).generateTestRepo(cardFilm)  // заполнить тестовый репозиторий
        Log.d(TAG, "onCreate: start generateTestRepo")

        initBottomNavigation()
        initFragmentManager(filmListFragment)

    }


    private fun initBottomNavigation() {
        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener { itemMenu ->
            when (itemMenu.itemId) {
                R.id.home_bottom_navigation -> {
                    initFragmentManager(filmListFragment)
                    true
                }
                R.id.favorit_bottom_navigation -> {
                    initFragmentManager(favoritFragment)
                    true
                }
                R.id.ratings_bottom_navigation -> {
                    initFragmentManager(ratingsFragment)
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun initFragmentManager(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onBackPressed() {
        val fragmentManager: FragmentManager = supportFragmentManager
        if(fragmentManager.backStackEntryCount == 0){
                  showClosingApp()
        }
 //       super.onBackPressed()
    }

    fun showClosingApp(){
        val contextView = findViewById<View>(R.id.fragment_container)
        Snackbar.make(contextView,R.string.close_App,Snackbar.LENGTH_SHORT)
            .setAnchorView(R.id.bottom_navigation)
            .setAction(R.string.yes) {
                finish()
            }
            .show()
    }

}