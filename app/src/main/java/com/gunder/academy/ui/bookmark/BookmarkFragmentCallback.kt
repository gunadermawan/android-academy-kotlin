package com.gunder.academy.ui.bookmark

import com.gunder.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)

}
