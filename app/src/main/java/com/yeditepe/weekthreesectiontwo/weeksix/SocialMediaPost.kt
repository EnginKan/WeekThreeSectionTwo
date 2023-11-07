package com.yeditepe.weekthreesectiontwo.weeksix

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.yeditepe.weekthreesectiontwo.R

data class Post(val image:Int,
                val sender: String,
                val sender_image: Int,
                var like:Int,
                var dislike:Int )
@ExperimentalMaterial3Api
@Composable
fun SinglePost(post: Post){

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
            Button(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.favorite_20px),
                    contentDescription ="" )
            }
            Button(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.outline_share_24),
                    contentDescription ="" )
            }
            
        }
            
        }

    }

}