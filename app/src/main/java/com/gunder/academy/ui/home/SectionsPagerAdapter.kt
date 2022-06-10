package com.gunder.academy.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gunder.academy.R
import com.gunder.academy.ui.academy.Academy
import com.gunder.academy.ui.bookmark.Bookmark

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? =
        mContext.resources.getString(TAB_TITLES[position])

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> Academy()
            1 -> Bookmark()
            else -> Fragment()
        }


    companion object {
        private val TAB_TITLES = intArrayOf(R.string.home, R.string.bookmark)
    }

}