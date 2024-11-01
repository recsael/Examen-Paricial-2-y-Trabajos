package com.example.examenparcial2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var button: Button
    private lateinit var textView: TextView
    private var user: FirebaseUser? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        button = findViewById(R.id.logout)
        textView = findViewById(R.id.user_details)
        user = auth.currentUser

        if (user == null) {
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish()
        }
        else {
            textView.text = user?.email
        }

        button.setOnClickListener{
            auth.signOut()
            val intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish()
        }

    }
}