package com.khvatid.ashuluk.di

import com.khvatid.ashuluk.domain.repository.KanbanRepository
import com.khvatid.ashuluk.domain.repository.LaunchEntityRepository
import com.khvatid.ashuluk.domain.service.AccountService
import com.khvatid.ashuluk.domain.usecase.repository.kanban.*
import com.khvatid.ashuluk.domain.usecase.repository.launch.GetLaunchEntityUseCase
import com.khvatid.ashuluk.domain.usecase.repository.launch.SetLaunchEntityUseCase
import com.khvatid.ashuluk.domain.usecase.service.*
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
    fun provideGetUserIdUseCase(accountService: AccountService): GetUserIdUseCase {
        return GetUserIdUseCase(accountService)
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

    @Provides
    fun provideGetTaskUseCase(repository: KanbanRepository): GetTaskUseCase {
        return GetTaskUseCase(repository)
    }

    @Provides
    fun provideUpdateTaskUseCase(repository: KanbanRepository): UpdateTaskUseCase {
        return UpdateTaskUseCase(repository)
    }

    @Provides
    fun provideDeleteTaskUseCase(repository: KanbanRepository): DeleteTaskUseCase {
        return DeleteTaskUseCase(repository)
    }

}