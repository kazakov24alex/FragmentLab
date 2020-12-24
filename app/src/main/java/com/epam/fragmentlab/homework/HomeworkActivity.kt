package com.epam.fragmentlab.homework

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.commitNow
import com.epam.fragmentlab.R
import com.epam.fragmentlab.homework.fragments.FirstStackRootFragment
import com.epam.fragmentlab.homework.fragments.SecondStackRootFragment
import kotlinx.android.synthetic.main.activity_homework.*

class HomeworkActivity : AppCompatActivity() {

    companion object {
        const val KEY_COUNTER = "key_counter"

        private const val TAG_FRAGMENT_1 = "FRAGMENT_1"
        private const val TAG_FRAGMENT_2 = "FRAGMENT_2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homework)

        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                setReorderingAllowed(true)
                add<FirstStackRootFragment>(R.id.fragment_container_view, TAG_FRAGMENT_1)
                add<SecondStackRootFragment>(R.id.fragment_container_view, TAG_FRAGMENT_2)
            }

            handleStackChanged(R.id.toggleStack1)
        }

        radiogroup.setOnCheckedChangeListener { radioGroup, id -> handleStackChanged(id) }
    }

    private fun handleStackChanged(toggleId: Int) {
        supportFragmentManager.commit {
            when (toggleId) {
                R.id.toggleStack1 -> {
                    supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_2)?.let { hide(it) }
                    supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_1)?.let {
                        show(it)
                        setPrimaryNavigationFragment(it)
                    }
                }
                R.id.toggleStack2 -> {
                    supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_1)?.let { hide(it) }
                    supportFragmentManager.findFragmentByTag(TAG_FRAGMENT_2)?.let {
                        show(it)
                        setPrimaryNavigationFragment(it)
                    }
                }
            }
        }
    }

}