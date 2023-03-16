package com.splanes.apps.dutyfruty.data.infrastructure.di

import com.splanes.apps.dutyfruty.data.features.authentication.repository.AuthRepositoryImpl
import com.splanes.apps.dutyfruty.domain.features.authentication.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}
