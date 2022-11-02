package com.khvatid.ashuluk.domain.repository

import com.khvatid.ashuluk.domain.entities.LaunchEntity

interface LaunchEntityRepository {

    fun get(): LaunchEntity

    fun save(launchEntity: LaunchEntity)

}