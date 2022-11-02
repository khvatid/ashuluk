package com.khvatid.ashuluk.data.storage.pref

import android.content.Context
import android.content.SharedPreferences
import com.khvatid.ashuluk.data.storage.LaunchModelStorage
import com.khvatid.ashuluk.data.storage.models.LaunchModel
import com.khvatid.ashuluk.domain.util.ParentDestination

private const val SHARED_PREFERENCE_NAME = "ashuluk_pref"
private const val KEY_START_DESTINATION = "start_destination_pref"
private const val KEY_TOKEN = "token_pref"

class LaunchModelStoragePref(context: Context) : LaunchModelStorage {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE
    )

    override fun get(): LaunchModel {
        return LaunchModel(
            startDestination = sharedPreferences.getString(
                KEY_START_DESTINATION,
                ParentDestination.MAIN
            )!!,
            token = sharedPreferences.getString(
                KEY_TOKEN, "empty"
            )!!
        )
    }

    override fun save(launchModel: LaunchModel) {
        sharedPreferences.edit()
            .putString(KEY_START_DESTINATION, launchModel.startDestination)
            .putString(KEY_TOKEN, launchModel.token)
            .apply()
    }
}