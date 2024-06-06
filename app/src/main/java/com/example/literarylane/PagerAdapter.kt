package com.example.literarylane

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return 3 // Number of Tabs
    }
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> InstructionsFragment()
            1 -> HomeFragment()
            2 -> ProfileFragment()
            else -> throw IllegalArgumentException("Invalid tab position")
        }
    }

    fun getTabView(context: Context, position: Int): View {
        val view = LayoutInflater.from(context).inflate(R.layout.tab_icon, null)
        val tabText = view.findViewById<TextView>(R.id.tab_text)
        val tabIcon = view.findViewById<ImageView>(R.id.tab_icon)

        when (position) { //Position of the tab icons
            0 -> {
                tabText.text = "Instrcutions"
                tabIcon.setImageResource(R.drawable.popup_btn)
            }
            1 -> {
                tabText.text = "Home"
                tabIcon.setImageResource(R.drawable.home_btn)
            }
            2 -> {
                tabText.text = "Profile"
                tabIcon.setImageResource(R.drawable.profile_btn)
            }
        }

        return view
    }
}
