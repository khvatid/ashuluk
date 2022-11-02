package com.khvatid.ashuluk.di

import com.khvatid.ashuluk.domain.repository.LaunchEntityRepository
import com.khvatid.ashuluk.domain.service.AccountService
import com.khvatid.ashuluk.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetLaunchEntityUseCase(repository: LaunchEntityRepository): GetLaunchEntityUseCase {
        return GetLaunchEntityUseCase(repository)
    }

    @Provides
    fun provideSetLaunchEntityUseCase(repository: LaunchEntityRepository): SetLaunchEntityUseCase {
        return SetLaunchEntityUseCase(repository)
    }

    @Provides
    fun provideCreateAccountToEmailAndPasswordUseCase(accountService: AccountService): CreateAccountToEmailAndPasswordUseCase {
        return CreateAccountToEmailAndPasswordUseCase(accountService)
    }

    @Provides
    fun provideAuthenticateToEmailAndPasswordUseCase(accountService: AccountService): AuthenticateToEmailAndPasswordUseCase {
        return AuthenticateToEmailAndPasswordUseCase(accountService)
    }

    @Provides
    fun provideDeleteAccountUseCase(accountService: AccountService): DeleteAccountUseCase {
        return DeleteAccountUseCase(accountService)
    }

    @Provides
    fun provideSignOutUseCase(accountService: AccountService): SignOutUseCase {
        return SignOutUseCase(accountService)
    }

}