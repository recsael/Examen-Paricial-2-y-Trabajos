package com.example.chatexamplebarnav

import Fragments.FragmentChats
import Fragments.FragmentProfile
import Fragments.FragmentUsers
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.chatexamplebarnav.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class  MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()

        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.currentUser == null){
            goToLogin()
        }


        viewFragmentChats()
        binding.buttonN.setOnItemSelectedListener {  item ->
            when(item.itemId){
                R.id.item_profile -> {
                    //
                    viewFragmentProfile()
                    true
                }
                R.id.item_users -> {
                    //
                    viewFragmentUsers()
                    true
                }
                R.id.item_chats -> {
                    //
                    viewFragmentChats()
                    true
                }
            else -> {
                false
            }
        }
        }
    }

    private fun goToLogin(){
        startActivity(Intent(applicationContext, optionsLoginActivity()::class.java ) )
    }

    private fun viewFragmentProfile(){
        binding.tvTitle.text = "PROFILE"
        val fragment = FragmentProfile()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.FragmentFF.id, fragment)
        fragmentTransaction.commit()
    }
    private fun viewFragmentUsers(){
        binding.tvTitle.text = "USERS"
        val fragment = FragmentUsers()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.FragmentFF.id, fragment)
        fragmentTransaction.commit()

    }
    private fun viewFragmentChats(){
        binding.tvTitle.text = "CHATS"
        val fragment = FragmentChats()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.FragmentFF.id, fragment )
        fragmentTransaction.commit()

    }
}