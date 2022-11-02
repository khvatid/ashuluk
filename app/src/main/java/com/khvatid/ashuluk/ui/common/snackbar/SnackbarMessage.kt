package com.khvatid.ashuluk.ui.common.snackbar

import android.content.res.Resources
import androidx.annotation.StringRes
import com.khvatid.ashuluk.R.string as AppText

sealed class SnackbarMessage{
    class StringSnackbar(val massage:String):SnackbarMessage()
    class ResourceSnackbar(@StringRes val message: Int):SnackbarMessage()

    companion object{
        fun SnackbarMessage.toMessage(resources: Resources): String {
            return when (this) {
                is StringSnackbar -> this.massage
                is ResourceSnackbar -> resources.getString(this.message)
            }
        }

        fun Throwable.toSnackBarMessage(): SnackbarMessage {
            val message = this.message.orEmpty()
            return if (message.isNotBlank()) StringSnackbar(message)
            else ResourceSnackbar(AppText.error_message)
        }
    }
}
