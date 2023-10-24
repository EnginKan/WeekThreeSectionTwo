package com.yeditepe.weekthreesectiontwo.mycomposables

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "night-mode", showSystemUi = true, showBackground = true, backgroundColor = 0xFF100F0F

)
annotation class FirstPreview

@Preview(uiMode= Configuration.UI_MODE_NIGHT_NO,
    showSystemUi = true,
    name = "Ligth Mode",
    device = "spec:width=1080px,height=2340px,dpi=440",
)
annotation class SecondPreview