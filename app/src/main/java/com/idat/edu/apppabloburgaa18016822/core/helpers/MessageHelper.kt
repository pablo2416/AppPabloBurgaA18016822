package com.idat.edu.apppabloburgaa18016822.core.helpers

import android.view.View
import com.google.android.material.snackbar.Snackbar

object MessageHelper {
    fun sendMessage(view: View, message: String) =
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
}