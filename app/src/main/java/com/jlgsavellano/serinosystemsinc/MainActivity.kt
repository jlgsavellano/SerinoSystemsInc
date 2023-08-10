package com.jlgsavellano.serinosystemsinc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.jlgsavellano.serinosystemsinc.ui.theme.SerinoSystemsIncTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val items = mutableListOf(
            Item("Toothpaste"),
            Item("Toothbrush"),
            Item("Mouthwash"),
            Item("Hand Soap"),
            Item("Candies"),
            Item("Cotton"),
            Item("Body Wash"),
            Item("Floss"),
            Item("Electric Toothbrush"),
            Item("Cologne")
        )

        setContent {
            SerinoSystemsIncTheme {
                ListScreen(items = items)
            }
        }
    }

    data class Item(val name: String, val price: Double = Random.nextDouble(1.0, 100.0))

    @Composable
    fun ListScreen(items: List<Item>) {
        LazyColumn {
            item {
                ListItemHeader("Sale")
            }

            items(items.size) { index ->
                ListItemCard(item = items[index])
            }

            item {
                ListItemTotal(total = items.sumOf { it.price })
            }
        }
    }

    @Composable
    fun ListItemHeader(header: String) {
        val styledText = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Blue)) {
                append(header)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {

            BasicText(
                text = styledText
            )
        }
    }

    @Composable
    fun ListItemCard(item: Item) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            BasicText(
                text = item.name
            )

            BasicText(
                text = String.format("$%.2f", item.price)
            )
        }

    }

    @Composable
    fun ListItemTotal(total: Double) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            BasicBoldText(
                text = "Total"
            )

            BasicBoldText(
                text = String.format("$%.2f", total)
            )
        }
    }

    @Composable
    fun BasicBoldText(text: String) {
        val styledText = buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(text)
            }
        }
        BasicText(
            text = styledText
        )
    }
}
