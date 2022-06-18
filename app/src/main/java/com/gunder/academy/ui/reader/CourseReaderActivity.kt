package com.gunder.academy.ui.reader

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gunder.academy.R
import com.gunder.academy.ui.reader.content.ModuleContent
import com.gunder.academy.ui.reader.list.ModuleList

class CourseReaderActivity : AppCompatActivity(), CourseReaderCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_reader)

        val bundle = intent.extras
        if (bundle != null) {
            val courseId = bundle.getString(EXTRA_COURSE_ID)
            if (courseId != null) {
                populateFragment()
            }
        }

    }

    private fun populateFragment() {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(ModuleList.TAG)
        if (fragment == null) {
            fragment = ModuleList.newInstance()
            fragmentTransaction.add(R.id.frame_container, fragment, ModuleList.TAG)
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }

    companion object {
        const val EXTRA_COURSE_ID = "extra_course_id"
    }

    override fun moveTo(position: Int, moduleId: String) {
        val fragment = ModuleContent.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.frame_container, fragment, ModuleContent.TAG)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }
}