package di

import androidx.compose.runtime.compositionLocalOf
import org.koin.core.KoinApplication

val LocalKoinApplication = compositionLocalOf<KoinApplication> {
    error("No local koinApplication providers")
}