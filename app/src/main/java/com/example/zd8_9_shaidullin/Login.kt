package com.example.zd8_9_shaidullin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.zd8_9_shaidullin.types.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Login : AppCompatActivity() {

    private var users = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val email = findViewById<EditText>(R.id.loginEmailField).text
        val password = findViewById<EditText>(R.id.loginPasswordField).text

        val navToRegister = findViewById<TextView>(R.id.navToRegisterText);
        val signInBtn = findViewById<Button>(R.id.signInBtn)

        signInBtn.setOnClickListener {
            if (email.isNullOrEmpty() || password.isNullOrEmpty())
            {
                Toast.makeText(this, "Enter all data", Toast.LENGTH_LONG).show()
            } else {
                checkUserData("${email}", "${password}")
            }
        }

        navToRegister.setOnClickListener {
            val intent = Intent(this, Register::class.java);
            startActivity(intent);
        }
    }

    private fun checkUserData(email: String, password: String) {

        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val gson = Gson()

        val json = sharedPreferences.getString("usersData", null)
        val type = object: TypeToken<ArrayList<User>>(){}.type

        if (json != null)
        {
            users = gson.fromJson(json, type)
            for (i in users) {
                if (email == i.email && password == i.password) {
                    Toast.makeText(this, "Successful login", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Account not found", Toast.LENGTH_SHORT).show()
                }
            }
        }

//        if (users == null) {
//            users = ArrayList<User>()
//        } else {
//            for (i in users) {
//                if (email == i.email && password == i.password) {
//                    Toast.makeText(this, "Successful login", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, MainActivity::class.java)
//                    startActivity(intent)
//                } else {
//                    Toast.makeText(this, "Account not found", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
    }
}