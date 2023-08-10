package com.jlgsavellano.serinosystemsinc

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jlgsavellano.serinosystemsinc.ui.theme.SerinoSystemsIncTheme


class App1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SerinoSystemsIncTheme {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    BasicButton(
                        text = "Go to App 2",
                        packageName = "com.jlgsavellano.serinosystemsincnew",
                        activityName = "App2Activity"
                    )
                }
            }
        }
    }

    @Composable
    fun BasicButton(text: String, packageName: String, activityName: String) {
        Button(
            onClick = {
                startActivity(Intent().apply {
                    component = ComponentName(packageName, "$packageName.$activityName")
                })

                finish()
            }
        ) {
            BasicText(text = text)
        }
    }
}