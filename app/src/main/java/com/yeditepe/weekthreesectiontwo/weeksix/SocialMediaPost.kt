package com.yeditepe.weekthreesectiontwo.weeksix

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yeditepe.weekthreesectiontwo.R
import com.yeditepe.weekthreesectiontwo.ui.theme.WeekThreeSectionTwoTheme

data class Post(val image:Int,
                val sender: String,
                val sender_image: Int,
                var like:Int,
                var dislike:Int )
@ExperimentalMaterial3Api
@Composable
fun SinglePost(post: Post){
    var selected by rememberSaveable{ mutableStateOf(false) }
    Card(onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
     colors= CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row {
            Image(painter = painterResource(id = post.sender_image),
                contentDescription = "",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
            )
            Text(text = post.sender,
            style= MaterialTheme.typography.titleMedium)
        }
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Image(painter = painterResource(id = post.image),
            contentDescription =" ",
            modifier= Modifier
                .fillMaxWidth()
                .padding(start = 3.dp, end = 3.dp)
                )
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        Row {
            Button(onClick = {
                selected=!selected
                if(selected){
                    post.like++
                    Log.d("Arttırma Kontrol",post.like.toString())
                }
                else {
                    post.like--
                    Log.d("Azaltma Kontrol",post.like.toString())
                }}) {
                Icon(painter = painterResource(
                    id =if(selected) R.drawable.favorite_fill1_wght400_grad0_opsz24
                        else R.drawable.favorite_fill0_wght400_grad0_opsz20),
                    contentDescription ="" )
            }
            Button(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.outline_share_24),
                    contentDescription ="" )
            }
            Text(
                text = post.like.toString() +" Like(s)" )
            Text(text = post.dislike.toString() + "Dislike(s)")
        }
            
        }

    }
@ExperimentalMaterial3Api
@Composable
fun PostScreen(posts: List<Post>){
    LazyColumn{
        items(posts){
            post->
            SinglePost(post = post)
        }
    }
}

@Preview
@ExperimentalMaterial3Api
@Composable
fun SinglePostPreview(){
    WeekThreeSectionTwoTheme {
        //SinglePost(post = Post(R.drawable.abdulkadir_ozbek, "Aldulkadir  Ozturk",
        //sender_image = R.drawable.abdulkadir_ozbek,like=0, dislike = 0))
    var post_list= mutableListOf<Post>()
        for(i in 1..100)
            post_list.add(
                Post(R.drawable.abdulkadir_ozbek, "Aldulkadir  Ozturk",
                    sender_image = R.drawable.abdulkadir_ozbek,like=0, dislike = 0)
            )
        PostScreen(posts = post_list)
    }
}
