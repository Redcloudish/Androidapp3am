package com.trios2024ammb.Androidapp3.viewmodel

import android.app.Application
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.google.android.libraries.places.api.model.Place
import com.trios2024ammb.Androidapp3.repository.BookmarkRepo

class MapsViewModel(application: Application) :
    AndroidViewModel(application) {

    private val TAG = "MapsViewModel"

    private val bookmarkRepo: BookmarkRepo = BookmarkRepo(
        getApplication())

    fun addBookmarkFromPlace(place: Place, image: Bitmap?) {

        val bookmark = bookmarkRepo.createBookmark()
        bookmark.placeId = place.id
        bookmark.name = place.name.toString()
        bookmark.longitude = place.latLng?.longitude ?: 0.0
        bookmark.latitude = place.latLng?.latitude ?: 0.0
        bookmark.phone = place.phoneNumber.toString()
        bookmark.address = place.address.toString()

        val newId = bookmarkRepo.addBookmark(bookmark)

        Log.i(TAG, "New bookmark $newId added to the database.")
    }
}
