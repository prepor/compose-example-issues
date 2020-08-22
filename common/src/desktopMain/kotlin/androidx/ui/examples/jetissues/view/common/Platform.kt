package androidx.ui.examples.jetissues.view.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.DesktopSelectionContainer
import androidx.compose.ui.selection.Selection
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun imageResource(res: String) = androidx.compose.ui.res.imageResource("drawable/$res.png")

@Composable
fun font(name: String, res: String, weight: FontWeight, style: FontStyle): Font =
       androidx.compose.ui.text.platform.font(name, "font/$res.ttf", weight, style)

@Composable
fun SelectionContainer(children: @Composable () -> Unit) {
    val selection = remember { mutableStateOf<Selection?>(null) }
    DesktopSelectionContainer(
        selection = selection.value,
        onSelectionChange = { selection.value = it },
        children = children
    )
}

@Composable
fun WithoutSelection(children: @Composable () -> Unit) {
    androidx.compose.ui.selection.SelectionContainer(
        selection = null,
        onSelectionChange = {},
        children = children
    )
}