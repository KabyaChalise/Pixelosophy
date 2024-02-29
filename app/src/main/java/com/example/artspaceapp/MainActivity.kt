package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
               ArtSpaceAppInfo()

            }
        }
    }
}

@Composable
fun ArtSpaceAppInfo() {

    var currentStep by remember { mutableStateOf(1) }

    when (currentStep) {
        1 -> {
            ArtSpaceAPP(
                imageInfo = R.string.spartan_info,
                imageAuthor = R.string.spartan_author,
                imageDate = R.string.spartan_date,
                drawableResourceId = R.drawable.spartan,
                Prev = {
                    currentStep = 3
                } ,
                Next = {
                    currentStep = 2
                }

            )
        }

        2 -> {
            ArtSpaceAPP(
                imageInfo = R.string.barbarian_info,
                imageAuthor = R.string.barbarian_author,
                imageDate = R.string.barbarian_date,
                drawableResourceId = R.drawable.barbarian,
                Prev = {
                    currentStep = 1
                } ,
                Next = {
                    currentStep = 3
                }
            )
        }
        3 -> {
            ArtSpaceAPP(
                imageInfo = R.string.samurai_info,
                imageAuthor = R.string.samurai_author,
                imageDate = R.string.samurai_date,
                drawableResourceId = R.drawable.samurai,
                Prev = {
                    currentStep = 2
                } ,
                Next = {
                    currentStep = 1
                }
            )
        }


    }
}
@Composable
fun ArtSpaceAPP(
    imageInfo: Int,
    imageAuthor: Int,
    imageDate: Int,
    drawableResourceId: Int,
    Prev: () -> Unit,
    Next: () -> Unit,
    modifier: Modifier = Modifier
) {
    var count by remember { mutableStateOf(1) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier
                .padding(20.dp, 20.dp)
                .shadow(5.dp)
        ) {
            Image(
                painter = painterResource(id = drawableResourceId),
                contentDescription = stringResource(id = imageInfo),
                contentScale = ContentScale.Fit,
                modifier = Modifier.padding(40.dp, 40.dp)
            )
        }
        Box(
            modifier
                .padding(20.dp, 20.dp)
                .background(Color(0xFFEBEAF3))
        ) {
            Column(
                modifier.padding(10.dp, 20.dp),

                ) {
                Text(
                    text = stringResource(id = imageInfo),
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Light

                )
                Row {
                    Text(
                        text = stringResource(id = imageAuthor),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 15.sp
                    )
                    Text(
                        text =stringResource(id = imageDate),
                        fontWeight = FontWeight.Thin
                    )
                }

            }
        }
        Row(
            modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = Prev,
                colors = ButtonDefaults.buttonColors(Color(0xFF495D91))

            ) {
                Text(
                    text = "Previous",
                    modifier.padding(24.dp, 0.dp),
                    color = Color(0xFFFFFFFF)

                )
            }
            Button(
                onClick = Next,
                colors = ButtonDefaults.buttonColors(Color(0xFF495D91))
            ) {
                Text(
                    text = "Next",
                    modifier.padding(40.dp, 0.dp),
                    color = Color(0xFFFFFFFF)

                )


            }
        }
    }
}

@Preview()
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceAppInfo()
    }
}

