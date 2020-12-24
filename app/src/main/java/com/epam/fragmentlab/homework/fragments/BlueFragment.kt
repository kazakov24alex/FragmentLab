package com.epam.fragmentlab.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.epam.fragmentlab.R
import com.epam.fragmentlab.homework.HomeworkActivity.Companion.KEY_COUNTER
import kotlinx.android.synthetic.main.fragment_blue.*

class BlueFragment : Fragment(R.layout.fragment_blue) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val counter = arguments?.getInt(KEY_COUNTER) ?: 1
        val newArgs = Bundle().apply { putInt(KEY_COUNTER, counter + 1) }

        counterTextView.text = "$counter"

        view.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                setCustomAnimations(R.anim.slide_in, R.anim.slide_out, R.anim.slide_in, R.anim.slide_out)
                add<BlueFragment>(R.id.root_fragment_container, args = newArgs)
                addToBackStack(null)
            }
        }
    }

}