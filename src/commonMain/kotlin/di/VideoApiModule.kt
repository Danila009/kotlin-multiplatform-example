package di

import data.api.dataSource.VideoDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val videoApiModule = module {
    singleOf(::VideoDataSource)
}