package com.example

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.*

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
          ScaffoldingScreen(
            modifier = Modifier
              .fillMaxSize()
              .padding(innerPadding)
          )
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldingScreen(modifier: Modifier = Modifier) {
  val context = LocalContext.current
  var isCompleted by remember { mutableStateOf(false) }

  Column(
    modifier = modifier
      .background(WarmBg)
      .fillMaxSize()
  ) {
    // App Bar Header
    TopAppBar(
      colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.Transparent
      ),
      title = {
        Text(
          text = "Project Scaffolding",
          fontSize = 20.sp,
          fontWeight = FontWeight.Medium,
          color = DarkText
        )
      },
      navigationIcon = {
        IconButton(
          onClick = {
            Toast.makeText(context, "Menu opened", Toast.LENGTH_SHORT).show()
          },
          modifier = Modifier.testTag("menu_button")
        ) {
          Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Menu icon",
            tint = DarkText
          )
        }
      },
      actions = {
        Box(
          modifier = Modifier
            .padding(end = 16.dp)
            .size(32.dp)
            .clip(CircleShape)
            .background(Color(0xFFEADDFF)),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = "JD",
            color = Color(0xFF21005D),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
          )
        }
      }
    )

    // Main area scrolling to prevent cut-offs
    Column(
      modifier = Modifier
        .weight(1f)
        .padding(horizontal = 16.dp, vertical = 8.dp)
        .verticalScroll(rememberScrollState()),
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      // Card 1: Folder Structure Card
      Card(
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = CardBg1),
        border = BorderStroke(1.dp, CardBorder1),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(
          modifier = Modifier.padding(20.dp)
        ) {
          Text(
            text = "1. FILE STRUCTURE",
            color = Color(0xFF6D5E5E),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            letterSpacing = 1.2.sp
          )
          Spacer(modifier = Modifier.height(12.dp))

          // Tree structure box
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(16.dp))
              .background(Color.White.copy(alpha = 0.5f))
              .border(1.dp, CardBorder1, RoundedCornerShape(16.dp))
              .padding(16.dp)
          ) {
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
              // Root lib/
              Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                  text = "└─ ",
                  fontFamily = FontFamily.Monospace,
                  color = DarkText.copy(alpha = 0.4f),
                  fontSize = 13.sp
                )
                Text(
                  text = "lib/",
                  fontFamily = FontFamily.Monospace,
                  color = EarthyAccent,
                  fontWeight = FontWeight.Bold,
                  fontSize = 13.sp
                )
              }
              // main.dart
              Row(
                modifier = Modifier.padding(start = 24.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "├─ ",
                  fontFamily = FontFamily.Monospace,
                  color = DarkText.copy(alpha = 0.4f),
                  fontSize = 13.sp
                )
                Text(
                  text = "main.dart",
                  fontFamily = FontFamily.Monospace,
                  color = Color(0xFF3A3836),
                  fontSize = 13.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                StatusBadge(text = "Core")
              }
              // constants.dart
              Row(
                modifier = Modifier.padding(start = 24.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "├─ ",
                  fontFamily = FontFamily.Monospace,
                  color = DarkText.copy(alpha = 0.4f),
                  fontSize = 13.sp
                )
                Text(
                  text = "constants.dart",
                  fontFamily = FontFamily.Monospace,
                  color = Color(0xFF3A3836),
                  fontSize = 13.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                StatusBadge(text = "Shared")
              }
              // models.dart
              Row(
                modifier = Modifier.padding(start = 24.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = "└─ ",
                  fontFamily = FontFamily.Monospace,
                  color = DarkText.copy(alpha = 0.4f),
                  fontSize = 13.sp
                )
                Text(
                  text = "models.dart",
                  fontFamily = FontFamily.Monospace,
                  color = Color(0xFF3A3836),
                  fontSize = 13.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                StatusBadge(text = "Data")
              }
            }
          }

          Spacer(modifier = Modifier.height(12.dp))
          Text(
            text = "A flat hierarchy keeps navigation fast on mobile IDEs.",
            color = Color(0xFF6D5E5E),
            fontSize = 13.sp,
            lineHeight = 17.sp
          )
        }
      }

      // Card 2: Code Snippet Card
      Card(
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(containerColor = CardBg2),
        border = BorderStroke(1.dp, CardBorder2),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(
          modifier = Modifier.padding(20.dp)
        ) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "2. INITIAL SHELL CODE",
              color = Color(0xFF6D5E5E),
              fontWeight = FontWeight.Bold,
              fontSize = 12.sp,
              letterSpacing = 1.2.sp
            )
            Text(
              text = "v1.0.0",
              fontFamily = FontFamily.Monospace,
              color = EarthyAccent,
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold
            )
          }
          Spacer(modifier = Modifier.height(12.dp))

          // Snippet 1
          Text(
            text = "constants.dart",
            fontFamily = FontFamily.Monospace,
            color = EarthyAccent,
            fontWeight = FontWeight.Bold,
            fontSize = 11.sp
          )
          Spacer(modifier = Modifier.height(4.dp))
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(12.dp))
              .background(Color(0xFF1E1E1E))
              .padding(12.dp)
          ) {
            Text(
              text = "const kAppName = 'LiteShell';",
              fontFamily = FontFamily.Monospace,
              color = Color(0xFFD4D4D4),
              fontSize = 12.sp
            )
          }

          Spacer(modifier = Modifier.height(12.dp))

          // Snippet 2
          Text(
            text = "models.dart",
            fontFamily = FontFamily.Monospace,
            color = EarthyAccent,
            fontWeight = FontWeight.Bold,
            fontSize = 11.sp
          )
          Spacer(modifier = Modifier.height(4.dp))
          Box(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(12.dp))
              .background(Color(0xFF1E1E1E))
              .padding(12.dp)
          ) {
            Text(
              text = """
                class AppUser {
                  final String id;
                  AppUser({required this.id});
                }
              """.trimIndent(),
              fontFamily = FontFamily.Monospace,
              color = Color(0xFFD4D4D4),
              fontSize = 11.sp,
              lineHeight = 15.sp
            )
          }
        }
      }
    }

    // Bottom Sticky CTA Action
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(WarmBg)
        .padding(16.dp)
    ) {
      Button(
        onClick = {
          isCompleted = !isCompleted
          val msg = if (isCompleted) {
            "Phase 1 Scaffolding Completed Successfully!"
          } else {
            "Reverted Phase 1 completion status."
          }
          Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        },
        colors = ButtonDefaults.buttonColors(
          containerColor = if (isCompleted) Color(0xFF6D5E5E) else DarkBtnBg,
          contentColor = Color.White
        ),
        shape = RoundedCornerShape(28.dp),
        modifier = Modifier
          .fillMaxWidth()
          .height(56.dp)
          .testTag("complete_button")
      ) {
        Row(
          horizontalArrangement = Arrangement.Center,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Text(
            text = if (isCompleted) "Phase 1 Completed" else "Complete Phase 1",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.width(8.dp))
          Icon(
            imageVector = if (isCompleted) Icons.Default.Check else Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Arrow Icon",
            modifier = Modifier.size(20.dp)
          )
        }
      }
    }
  }
}

@Composable
fun StatusBadge(text: String, modifier: Modifier = Modifier) {
  Box(
    modifier = modifier
      .clip(RoundedCornerShape(4.dp))
      .background(PrimaryBadge)
      .padding(horizontal = 6.dp, vertical = 2.dp)
  ) {
    Text(
      text = text,
      color = Color(0xFF3A3836),
      fontSize = 10.sp,
      fontWeight = FontWeight.Bold
    )
  }
}
