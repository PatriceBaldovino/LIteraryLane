package com.example.literarylane

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.TextView

class ProfileFragment : Fragment() {
    private lateinit var textViewUsername: TextView
    private lateinit var textViewEmail: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewUsername = view.findViewById(R.id.textViewUsername)
        textViewEmail = view.findViewById(R.id.textViewEmail)

        // Retrieve the username and email from SharedPreferences
        val sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "") // Default to an empty string if not found
        val email = sharedPreferences.getString("email", "") // Default to an empty string if not found

        // Update the UI with the username and email
        textViewUsername.text = username
        textViewEmail.text = email
    }
}