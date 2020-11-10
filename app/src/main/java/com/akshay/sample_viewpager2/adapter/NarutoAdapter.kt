package com.akshay.sample_viewpager2.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akshay.sample_viewpager2.fragment.NarutoFragment

/**
 * Created by akshaynandwana on
 * 10, November, 2020
 **/
class NarutoAdapter(
    activity: AppCompatActivity,
    private val itemsCount: Int
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = itemsCount

    override fun createFragment(position: Int): Fragment {
        return NarutoFragment.getInstance(position)
    }
}