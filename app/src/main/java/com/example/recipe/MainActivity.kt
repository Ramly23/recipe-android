package com.example.recipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipe.ui.theme.RecipeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainLayout()
                }
            }
        }
    }
}

@Composable
fun MainLayout() {
    var isLayout1Visible by remember { mutableStateOf(true) }

    if (isLayout1Visible) {
        LayoutWithButton { isLayout1Visible = false }
    } else {
        LayoutWithText { isLayout1Visible = true }
    }
}

@Composable
fun LayoutWithButton(onButtonClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .background(Color(0xFF444444))
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 20.dp)
                .fillMaxWidth()
        ) {
            Text (
                text = stringResource(R.string.header_title),
                fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                color = Color(0xFFFFFFFF)
            )
        }
        // Below Header
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFececec))
                .padding(16.dp)
        ) {
            val image = painterResource(R.drawable.food)
            Text (
                text = stringResource(R.string.food_name),
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 38.sp,
                    color = Color.DarkGray,
                    textDecoration = TextDecoration.Underline,
                ),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 15.dp)
            )
            Image (
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(320.dp)
            )
            Button(
                onClick = { onButtonClick() },
                colors = ButtonDefaults.buttonColors(Color.Gray),
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(200.dp)
            ) {
                // Button text
                Text(
                    text = "View Recipe",
                    color = Color(0xFFFFFFFF),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(top = 4.dp, bottom = 4.dp)
                )
            }
        }
    }
}

@Composable
fun LayoutWithText(onTextClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color(0xFF444444))
                .padding(start = 20.dp, top = 20.dp, bottom = 20.dp, end = 20.dp)
                .fillMaxWidth()
        ) {
            Text (
                text = "Recipe",
                style = TextStyle(
                    color = Color(0xFFFFFFFF),
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                    fontSize = 18.sp
                )
            )
            Icon (
                Icons.Default.MoreVert,
                contentDescription = null,
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFececec))
                .padding(start = 32.dp, end = 32.dp)
        ) {
            Text (
                text = stringResource(R.string.food_name),
                style = TextStyle(
                    textDecoration = TextDecoration.Underline,
                    fontSize = 34.sp,
                    color = Color.DarkGray,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold)),
                ),
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Text (
                text = "Ingredients",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
            )
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = "•      4 plum tomatoes\n" +
                            "•     6 basil leaves\n" +
                            "•     3 garlic cloves, chopped\n" +
                            "•     3 TB olive oil\n",
                    style = TextStyle(
                        lineHeight = 30.sp,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                )
            }
            Text (
                text = "Directions",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                )
            )
            Column(
                modifier = Modifier
                    .padding(top = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.directions),
                    style = TextStyle(
                        color = Color.Black,
                        lineHeight = 25.sp,
                        fontSize = 16.sp
                    )
                )
            }
            Button(
                onClick = { onTextClick() },
                colors = ButtonDefaults.buttonColors(Color.Gray),
                shape = MaterialTheme.shapes.small,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(200.dp)
            ) {
                Text (
                    text = "Go Back To Main Page",
                    color = Color(0xFFFFFFFF),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.poppins_semibold))
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "My Preview"
)

@Composable
fun RecipePreview() {
    RecipeTheme {
        MainLayout()
    }
}