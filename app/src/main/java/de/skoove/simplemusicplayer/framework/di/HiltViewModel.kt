package de.skoove.simplemusicplayer.framework.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import de.skoove.simplemusicplayer.framework.Interactors
import de.skoove.core.data.TestDatasource
import de.skoove.core.data.TestRepository
import de.skoove.core.usecases.FindMusicByName
import de.skoove.core.usecases.GetMusicList

@InstallIn(ViewModelComponent::class)
@Module
class HiltViewModel {

    @Provides
    @ViewModelScoped

    fun provideTestRepository(testDatasource: TestDatasource) = TestRepository(testDatasource)

    @Provides
    @ViewModelScoped
    fun provideInterActors(testRepository: TestRepository) =
        Interactors(
            GetMusicList(testRepository),
            FindMusicByName(testRepository)
        )
}