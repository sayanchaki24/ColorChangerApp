package com.example.colorchangerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.colorchangerapp.ui.theme.ColorChangerAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColorChangerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var backgroundColor by remember { mutableStateOf(Color.White) }

    fun getRandomColor(): Color {
        val red = Random.nextInt(0, 256)
        val green = Random.nextInt(0, 256)
        val blue = Random.nextInt(0, 256)
        return Color(red, green, blue)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        // Top-right multiline text
        Text(
            text = "22BTAI142 – Shiva Bhagavan S\n" +
                    "22BTAI143 – HARSHIT TRIVEDI\n" +
                    "22BTAI144 – THIPPESH H K\n" +
                    "22BTAI145 – Pranesh V",
            modifier = Modifier.align(Alignment.TopEnd),
            style = MaterialTheme.typography.bodySmall,
            color = Color.DarkGray
        )

        // Centered greeting and button
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Hello $name!")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                backgroundColor = getRandomColor()
            }) {
                Text("Change Colour")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ColorChangerAppTheme {
        Greeting("Android")
    }
}
