package com.khvatid.ashuluk.di

import com.khvatid.ashuluk.domain.repository.KanbanRepository
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
    fun provideGetLaunchEntityUseCase(repository: LaunchEntityRepository)
            : GetLaunchEntityUseCase {
        return GetLaunchEntityUseCase(repository)
    }

    @Provides
    fun provideSetLaunchEntityUseCase(repository: LaunchEntityRepository)
            : SetLaunchEntityUseCase {
        return SetLaunchEntityUseCase(repository)
    }

    @Provides
    fun provideCreateAccountToEmailAndPasswordUseCase(accountService: AccountService)
            : CreateAccountToEmailAndPasswordUseCase {
        return CreateAccountToEmailAndPasswordUseCase(accountService)
    }

    @Provides
    fun provideAuthenticateToEmailAndPasswordUseCase(accountService: AccountService)
            : AuthenticateToEmailAndPasswordUseCase {
        return AuthenticateToEmailAndPasswordUseCase(accountService)
    }

    @Provides
    fun provideDeleteAccountUseCase(accountService: AccountService)
            : DeleteAccountUseCase {
        return DeleteAccountUseCase(accountService)
    }

    @Provides
    fun provideSignOutUseCase(accountService: AccountService)
            : SignOutUseCase {
        return SignOutUseCase(accountService)
    }

    @Provides
    fun provideAddTaskListenerUseCase(repository: KanbanRepository): AddTaskListenerUseCase {
        return AddTaskListenerUseCase(repository = repository)
    }

    @Provides
    fun provideRemoveTaskListenerUseCase(repository: KanbanRepository): RemoveTaskListenerUseCase {
        return RemoveTaskListenerUseCase(repository = repository)
    }

    @Provides
    fun provideSaveTaskUseCase(repository: KanbanRepository): SaveTaskUseCase {
        return SaveTaskUseCase(repository)
    }


}