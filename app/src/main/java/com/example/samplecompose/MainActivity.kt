package com.example.samplecompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfilePreview()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    MaterialTheme {
        Column {
            toolbar(title = stringResource(id = R.string.app_name))

            coverHeader(name = stringResource(id = R.string.profile_name),stringResource(id = R.string.function_name))

            aboutMe(desc = stringResource(id = R.string.desc_about))

          //  bottomNavigation()

        }
    }
}

@Composable
fun toolbar(title:String){
    TopAppBar(
        title = { Text(text = title,color = Color.White) },
        backgroundColor = colorResource(id = R.color.purple_200)
    )
}

@Composable
fun bottomNavigation(){
    BottomAppBar(backgroundColor = colorResource(id = R.color.purple_200)) {
        Text(text = "Menu 1",color = Color.White,modifier = Modifier.padding(8.dp))
        Text(text = "Menu 2",color = Color.White,modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun coverHeader(name:String,profileName:String){
    Card(modifier = androidx.compose.ui.Modifier.padding(16.dp),
        elevation = 16.dp){
        ConstraintLayout {
            val (image,text1,text2) = createRefs()
            Image(imageResource(id = R.drawable.cover))
            Image(imageResource(id = R.drawable.image_profile),
                modifier = androidx.compose.ui.Modifier.size(68.dp).constrainAs(image) {
                    top.linkTo(parent.top, margin = 64.dp)})
            Text(name,style = TextStyle(fontWeight = FontWeight.Bold),modifier = androidx.compose.ui.Modifier.constrainAs(text1) {
                top.linkTo(parent.top, margin = 85.dp);start.linkTo(image.start, margin = 80.dp)})
            Text(profileName,style = TextStyle(fontStyle = FontStyle.Italic),
                fontSize = 12.sp,
                modifier = androidx.compose.ui.Modifier.constrainAs(text2) {
                    top.linkTo(parent.top, margin = 102.dp);start.linkTo(image.start, margin = 80.dp)})
        }
    }
}

@Composable
fun aboutMe(desc:String){
    Card(modifier = androidx.compose.ui.Modifier.padding(start = 16.dp,end = 16.dp,bottom = 16.dp).fillMaxWidth().preferredHeight(300.dp),
        elevation = 16.dp) {

        Column {
            Text(
                stringResource(id = R.string.title_about), style = TextStyle(fontWeight = FontWeight.Bold),
                fontSize = 18.sp,
                modifier = androidx.compose.ui.Modifier.padding(16.dp)
            )

            ScrollableColumn {

                Text(
                    desc, style = TextStyle(fontWeight = FontWeight.Light),
                    modifier = androidx.compose.ui.Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                )
            }

            Text("")
        }


    }
}



