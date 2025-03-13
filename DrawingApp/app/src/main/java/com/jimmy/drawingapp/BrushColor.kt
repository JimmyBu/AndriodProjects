package com.jimmy.drawingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.godaddy.android.colorpicker.ClassicColorPicker
import com.godaddy.android.colorpicker.HsvColor

@Composable
fun BrushColorSelector(onColorSelected: (Color) -> Unit) {
    var showOptions by remember { mutableStateOf(false) }
    var selectedColor by remember { mutableStateOf(Color.Black) }
    val hsvColor = HsvColor.from(selectedColor)

    Box(contentAlignment = Alignment.Center) {
        IconButton(onClick = { showOptions = !showOptions }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_color_palette),
                contentDescription = "Select Brush Color"
            )
        }

        if (showOptions) {
            Popup(
                alignment = Alignment.TopCenter,
                onDismissRequest = { showOptions = false }
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .size(200.dp)
                        .clickable { /*  */ }
                        .padding(16.dp)
                ) {
                    ClassicColorPicker(
                        color = hsvColor,
                        showAlphaBar = true,
                        onColorChanged = { hsv ->
                            selectedColor = hsv.toColor()
                            onColorSelected(selectedColor)
                        }
                    )
                }
            }
        }
    }
}