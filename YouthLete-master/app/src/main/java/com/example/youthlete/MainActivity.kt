package com.example.youthlete

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.youthlete.fragment.HomeFragment
import com.example.youthlete.fragment.ProfileFragment
import com.example.youthlete.login.loginActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var sharedPreferences: SharedPreferences

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var frameContainer: FrameLayout

    private lateinit var homeFragment: Fragment
    private lateinit var profileFragment: Fragment

    private lateinit var activeFragment: Fragment

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        auth = FirebaseAuth.getInstance()
        sharedPreferences = getSharedPreferences("LOGIN_STATUS", Context.MODE_PRIVATE)

        //bagian fragment
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        frameContainer = findViewById(R.id.frame_container)

        homeFragment = HomeFragment()
        profileFragment = ProfileFragment()


        activeFragment = homeFragment
        loadFragment(activeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    if (activeFragment != homeFragment) {
                        activeFragment = homeFragment
                        loadFragment(activeFragment)
                    }
                    true
                }
                R.id.navigation_dashboard -> {
                    if (activeFragment != profileFragment) {
                        activeFragment = profileFragment
                        loadFragment(activeFragment)
                    }
                    true
                }
                else -> false
            }
        }

    }

    override fun onStart() {
        super.onStart()

        // Cek status login pengguna saat aplikasi dibuka kembali
        if (!sharedPreferences.getBoolean("LOGGED_IN", false)) {
            logout() // Jika tidak dalam status login, maka logout
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_logout -> {
                // Tambahkan kode logout di sini
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        FirebaseAuth.getInstance().signOut()

        // Set status login pengguna ke false menggunakan Shared Preferences
        val editor = sharedPreferences.edit()
        editor.putBoolean("LOGGED_IN", false)
        editor.apply()

        val intent = Intent(this, loginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment)
        fragmentTransaction.commit()
    }


}
