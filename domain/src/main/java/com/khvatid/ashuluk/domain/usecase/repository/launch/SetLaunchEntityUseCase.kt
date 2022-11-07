package com.khvatid.ashuluk.domain.usecase.repository.launch

import com.khvatid.ashuluk.domain.entities.LaunchEntity
import com.khvatid.ashuluk.domain.repository.LaunchEntityRepository

class SetLaunchEntityUseCase(private val repository: LaunchEntityRepository) {
    fun execute(launchEntity: LaunchEntity) {
        repository.save(launchEntity = launchEntity)
    }
}