package com.khvatid.ashuluk.data.storage

import com.khvatid.ashuluk.data.storage.models.LaunchModel

interface LaunchModelStorage {

    fun get() : LaunchModel
    fun save(launchModel: LaunchModel)

}