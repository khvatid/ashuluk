package com.khvatid.ashuluk.data.repositories

import com.khvatid.ashuluk.data.storage.LaunchModelStorage
import com.khvatid.ashuluk.data.storage.models.LaunchModel
import com.khvatid.ashuluk.domain.entities.LaunchEntity
import com.khvatid.ashuluk.domain.repository.LaunchEntityRepository

class LaunchEntityRepositoryImp(private val storage: LaunchModelStorage) : LaunchEntityRepository {
    override fun get(): LaunchEntity {
        return storage.get().toLaunchEntity()
    }

    override fun save(launchEntity: LaunchEntity) {
        storage.save(launchEntity.toLaunchModel())
    }


    private fun LaunchModel.toLaunchEntity(): LaunchEntity {
        return LaunchEntity(startDestination, token)
    }

    private fun LaunchEntity.toLaunchModel(): LaunchModel {
        return LaunchModel(startDestination, token)
    }
}