package com.akshay.sample_viewpager2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akshay.sample_viewpager2.R
import kotlinx.android.synthetic.main.fragment_naruto.view.*

/**
 * Created by akshaynandwana on
 * 10, November, 2020
 **/
class NarutoFragment : Fragment() {

    companion object {

        fun getInstance(position: Int): NarutoFragment {
            val args = Bundle()
            args.putInt("position", position)
            val fragment = NarutoFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_naruto, container, false)
        val position = arguments!!.getInt("position")
        when (position) {
            0 -> {
                view.name_naruto.text = "Naruto Uzumaki"
                view.container.setBackgroundColor(
                    context!!.resources.getColor(
                        android.R.color.holo_orange_light
                    )
                )
            }
            1 -> {
                view.name_naruto.text = "Sasuke Uchiha"
                view.container.setBackgroundColor(
                    context!!.resources.getColor(
                        android.R.color.holo_blue_light
                    )
                )
            }
            2 -> {
                view.name_naruto.text = "Kakashi Hatake"
                view.container.setBackgroundColor(
                    context!!.resources.getColor(
                        android.R.color.darker_gray
                    )
                )
            }
        }
        return view.rootView
    }
}