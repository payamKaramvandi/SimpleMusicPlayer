package de.skoove.simplemusicplayer.framework.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.skoove.simplemusicplayer.framework.repository.TestRepository
import de.skoove.core.data.TestDatasource

@Module
@InstallIn(SingletonComponent::class)
abstract class HiltTestDataSource {

    @Binds
    abstract fun bindTestDatasource(
        testRepository: TestRepository
    ): TestDatasource
}
