package com.example.businesscard


import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.R
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier=Modifier.fillMaxSize(),
                    color= MaterialTheme.colorScheme.background

                ) {
                    BusinessCard()
                }
            }
        }
    }
}
@Composable
fun BusinessCard(){
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White)
            ) {
        Image(painter = painterResource(R.drawable.backphoto),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.graphicsLayer(scaleY =1.95f ,  scaleX = 2.0f)
        )
        Row (
            modifier = Modifier.fillMaxSize()
        ){
            Column (modifier = Modifier.weight(1f),
               // horizontalAlignment = Alignment.Start
            ) {
                val logo: Painter= painterResource(R.drawable.khabib_wo_water)
                Image(
                    painter=logo,
                    contentDescription = "Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(140.dp).graphicsLayer(scaleY =0.9f ,  scaleX = 0.9f).clip(CircleShape),
                )

                Text(
                    text="College @CSI",
                    fontSize= 20.sp,
                    color = Color.White
                )
                Text(
                    text="Computer Science ",
                    fontSize= 15.sp,
                    color = Color.White
                )
            }
            Column(
                modifier = Modifier.weight(2f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Loay Elasmar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "Student",
                    fontSize = 16.sp,
                    color = Color.LightGray,
                    lineHeight = 20.sp
                )
                Spacer(modifier = Modifier.height(19.dp))
                Info(R.drawable.phone_icon," (123)456-7890" )
                Info(R.drawable.mail_icon," Khabib@gmail.com" )


            }
        }





    }
}




@Composable
fun Info(profile: Int, text: String) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp)
    ) {

        Image(
            painter = painterResource(profile),
            contentDescription = "Profile",
            modifier = Modifier.size(20.dp),
            contentScale= ContentScale.Crop,
            colorFilter = ColorFilter.tint(Color.White)
        )

        Text(
            text=text,
            fontSize = 12.sp,
            color=Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview(){
    BusinessCardTheme {
        BusinessCard()
    }
}





