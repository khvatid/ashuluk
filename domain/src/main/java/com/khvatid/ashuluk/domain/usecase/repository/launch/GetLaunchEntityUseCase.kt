package com.khvatid.ashuluk.domain.usecase.repository.launch

import com.khvatid.ashuluk.domain.entities.LaunchEntity
import com.khvatid.ashuluk.domain.repository.LaunchEntityRepository

class GetLaunchEntityUseCase(private val repository: LaunchEntityRepository) {

    fun execute(): LaunchEntity{
        return  repository.get()
    }
}