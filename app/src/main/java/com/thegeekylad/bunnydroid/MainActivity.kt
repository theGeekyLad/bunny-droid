package com.thegeekylad.bunnydroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.thegeekylad.bunnydroid.data.CommandLoader
import com.thegeekylad.bunnydroid.ui.theme.BunnyDroidTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val restart = mutableStateOf(true)
    val commandStr = mutableStateOf("")
    @Inject lateinit var commandLoader: CommandLoader

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val focusRequester = rememberRequestFocusOnStart(restart)

            BunnyDroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding).padding(16.dp).fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier.focusRequester(focusRequester).weight(weight = 1f, fill = true),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "BunnyDroid",
                                fontSize = TextUnit(value = 64f, type = TextUnitType.Sp)
                            )
                        }
                        Column(
                            modifier = Modifier.focusRequester(focusRequester).weight(weight = 1f, fill = true),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TextField(
                                modifier = Modifier.focusRequester(focusRequester),
                                placeholder = { Text("Where you ya wanna hop?") },
                                value = commandStr.value,
                                keyboardOptions = KeyboardOptions(autoCorrect = false, capitalization = KeyboardCapitalization.None),
                                onValueChange = { value ->
                                    if (value.endsWith("\n")) {
                                        commandLoader.run(applicationContext, commandStr.value)
                                    } else {
                                        commandStr.value = value
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        restart.value = true
        commandStr.value = ""
    }
}

@Composable
fun rememberRequestFocusOnStart(state: MutableState<Boolean>): FocusRequester {
    val focusRequester = remember { FocusRequester() }
    val keyboardController = LocalSoftwareKeyboardController.current
    val requested = remember { mutableStateOf(false) }

    if (state.value) {
        LaunchedEffect(state.value) {
            state.value = false
            try {
                focusRequester.requestFocus()
                keyboardController?.show()
                requested.value = true
            } catch (e: Exception) {
                delay(100)
            }
        }
    }
    return focusRequester
}
