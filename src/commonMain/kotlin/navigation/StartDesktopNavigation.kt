package navigation

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidedValue
import screen.MainScreen

@Composable
fun StartNavigation(
    startScreen: String,
    vararg values: ProvidedValue<*>
) {

    val navController = rememberNavController(startDestination = startScreen)

    CompositionLocalProvider(
        *values
    ){
        NavigationHost(navController.value){
            composable(Screen.MainScreen.route){
                TextButton(
                    onClick = {
                        navController.value.navigate(Screen.UserScreen.route)
                    }
                ){
                    Text("MainScreen open")
                }
            }
            composable(Screen.UserScreen.route){
                MainScreen()
            }
        }.build()
    }
}