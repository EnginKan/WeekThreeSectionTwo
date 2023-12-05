package com.yeditepe.weekthreesectiontwo.weeknine

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ImageViewModel: ViewModel() {

    var image_uri by mutableStateOf<Uri?>(null)
        private set

    fun updateUri(uri: Uri?){
        this.image_uri=uri
    }
}