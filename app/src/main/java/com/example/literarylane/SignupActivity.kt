package com.example.literarylane

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast

class SignupActivity : AppCompatActivity() {
    private lateinit var editTextUsername: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonSave: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonSave = findViewById(R.id.buttonSave)

        buttonSave.setOnClickListener {
            val username = editTextUsername.text.toString()
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // Save data to SharedPreferences
            val sharedPreferences = getSharedPreferences("user_prefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("username", username)
            editor.putString("email", email) // Save the email
            editor.putString("password", password)
            editor.apply()

            Toast.makeText(this, "Signup successful!", Toast.LENGTH_SHORT).show()

            // Navigate to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}