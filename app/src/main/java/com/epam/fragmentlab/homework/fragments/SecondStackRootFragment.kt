package com.epam.fragmentlab.homework.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.epam.fragmentlab.R
import com.epam.fragmentlab.homework.fragments.BlueFragment

class SecondStackRootFragment : Fragment(R.layout.fragment_root) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.commit {
            setReorderingAllowed(true)
            add<BlueFragment>(R.id.root_fragment_container)
            addToBackStack(null)
        }
    }

}