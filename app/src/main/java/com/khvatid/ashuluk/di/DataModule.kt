package com.khvatid.ashuluk.di

import android.content.Context
import com.khvatid.ashuluk.data.repositories.LaunchEntityRepositoryImp
import com.khvatid.ashuluk.data.service.AccountServiceImp
import com.khvatid.ashuluk.data.storage.LaunchModelStorage
import com.khvatid.ashuluk.data.storage.pref.LaunchModelStoragePref
import com.khvatid.ashuluk.domain.repository.LaunchEntityRepository
import com.khvatid.ashuluk.domain.service.AccountService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideLaunchModelStorage(@ApplicationContext context: Context): LaunchModelStorage {
        return LaunchModelStoragePref(context)
    }

    @Provides
    @Singleton
    fun provideLaunchEntityRepository(storage: LaunchModelStorage): LaunchEntityRepository {
        return LaunchEntityRepositoryImp(storage)
    }

    @Provides
    @Singleton
    fun provideAccountService():AccountService{
        return AccountServiceImp()
    }

}