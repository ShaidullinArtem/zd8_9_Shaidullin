package com.example.zd8_9_shaidullin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.zd8_9_shaidullin.types.User
import com.example.zd8_9_shaidullin.utils.UserUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Register : AppCompatActivity() {

    private var users = ArrayList<User>()
    private var userUtils = UserUtils();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val email = findViewById<EditText>(R.id.registerEmailField).text
        val password = findViewById<EditText>(R.id.registerPasswordField).text
        val confirmPassword = findViewById<EditText>(R.id.registerConfirmPassword).text

        val signUpBtn = findViewById<Button>(R.id.signUpBtn)
        val navToLoginText = findViewById<TextView>(R.id.navToLoginText)


        signUpBtn.setOnClickListener {
            val userExist: Boolean = checkUserExist("${email}")
            val isConfirm: Boolean = userUtils.isPasswordsConfirm("${password}", "${confirmPassword}")

/*            if (email.isNullOrEmpty() || password.isNullOrEmpty() || confirmPassword.isNullOrEmpty()) {
                Toast.makeText(this ,"Invalid data!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }*/
            Toast.makeText(this, "Success register user", Toast.LENGTH_LONG).show()
            saveUserData("${email}", "${password}")
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        navToLoginText.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    @SuppressLint("CommitPrefEdits")
    private fun saveUserData(email: String, password: String) {

        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()

        users.add(User(email, password))
        val json: String = gson.toJson(users)

        editor.putString("usersData", json)
        editor.apply()
    }

     private fun checkUserExist(email: String): Boolean {

        val sharedPreferences = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val gson = Gson()

        val json = sharedPreferences.getString("usersData", null)
        val type = object : TypeToken<ArrayList<User>>() {}.type

        if (json == null) {
            return false
        } else {
            users = gson.fromJson(json, type)
            for (i in users) {
                if (email == i.email) return true
            }
            return false
        }
    }
}