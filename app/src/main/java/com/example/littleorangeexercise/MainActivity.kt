package com.example.littleorangeexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.example.littleorangeexercise.ui.theme.LittleOrangeExerciseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleOrangeExerciseTheme {
                ChatBubbleScreen()
            }
        }
    }
}

@Composable
fun ChatBubbleScreen() {
    val messages = listOf(
        ChatMessage("Celestia", "Aku Bingung, Kamu pun Bingung", isUser = false),
        ChatMessage("Renata", "Sama cuk, cang juga bingung", isUser = true),
        ChatMessage("Celestia", "Kita satu server nih", isUser = false),
        ChatMessage("Renata", "Aelah caonima le", isUser = true),
    )

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            messages.forEach { message ->
                ChatBubble(name = message.name, text = message.text, isUser = message.isUser)
            }
        }
    }
}

data class ChatMessage(val name: String, val text: String, val isUser: Boolean)

@Composable
fun ChatBubble(name: String, text: String, isUser: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (isUser) Arrangement.End else Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (!isUser) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }

        Column(horizontalAlignment = if (isUser) Alignment.End else Alignment.Start) {
            if (!isUser) {
                Text(
                    text = name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF00796B)
                )
                Spacer(modifier = Modifier.height(4.dp))
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                shadowElevation = 2.dp,
                color = if (isUser) Color(0xFFDCF8C6) else Color.White
            ) {
                Text(
                    text = text,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Whangsapp() {
    LittleOrangeExerciseTheme {
        ChatBubbleScreen()
    }
}
