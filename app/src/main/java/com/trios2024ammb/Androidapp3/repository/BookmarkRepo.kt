package com.trios2024ammb.Androidapp3.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.trios2024ammb.Androidapp3.db.BookmarkDao
import com.trios2024ammb.Androidapp3.db.PlaceBookDatabase
import com.trios2024ammb.Androidapp3.model.Bookmark


class BookmarkRepo(context: Context) {

    private val db = PlaceBookDatabase.getInstance(context)
    private val bookmarkDao: BookmarkDao = db.bookmarkDao()

    fun addBookmark(bookmark: Bookmark): Long? {
        val newId = bookmarkDao.insertBookmark(bookmark)
        bookmark.id = newId
        return newId
    }

    fun createBookmark(): Bookmark {
        return Bookmark()
    }

    val allBookmarks: LiveData<List<Bookmark>>
        get() {
            return bookmarkDao.loadAll()
        }
}
