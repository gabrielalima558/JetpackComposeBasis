package com.example.composebasis

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composebasis.ui.theme.Backgroud
import com.example.composebasis.ui.theme.ComposeBasisTheme
import com.example.composebasis.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasisTheme {
                FeedItem()
            }
        }
    }
}

@Composable
fun FeedItem() {
    Column {
        Box {
            Image(painter = painterResource(id = R.drawable.thumb), contentDescription = "Thumb")
            Text(
                text = "26:15",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(4.dp, 8.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Chanel Image",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
            )
            //outra opcao é usar o spacer entre os itens ao inés de passar o horizontalArrangement no row
            //mas pode repetir muito código
            Column {
                Text(
                    text = "Jetpack Compose - Fundamentos"
                )
                //size é igual o padding
                Spacer(modifier = Modifier.size(16.dp))
                Row {
                    Text(
                        text = "Gabriela Lima",
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "| 247 views",
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp
                    )
                    Text(
                        text = "| 2 weeeks ago",
                        fontWeight = FontWeight.Light,
                        fontSize = 14
                            .sp
                    )
                }
            }
        }
    }
}

@Composable
//esse StringRes garante que esse textHasId seja um int do tipo string res do android
fun CustomText(@StringRes textHasId: Int) {
    Text(
        text = stringResource(id = textHasId),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                Log.d("Wellcome", "Clicked")
            },
        color = Teal200,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body1
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasisTheme {
        FeedItem()
    }
}