package com.jimmy.drawingapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Popup


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrawingScreen() {
    var brushSize by remember { mutableStateOf(20f) }
    var brushColor by remember { mutableStateOf(Color.Black) }
    val drawingViewState = remember { mutableStateOf<DrawingView?>(null) }


    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.weight(1f)) {
            DrawingCanvas(brushSize, brushColor, drawingViewState)
        }

        BottomBar(
            onBrushSizeSelected = { newSize -> brushSize = newSize },
            onColorSelected = { newColor -> brushColor = newColor },
            onUndo = { drawingViewState.value?.onClickUndo() },
        )
    }
}

@Composable
fun BottomBar(onBrushSizeSelected: (Float) -> Unit,
              onColorSelected: (Color) -> Unit,
              onUndo : () -> Unit,
              ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Gray.copy(alpha = 0.2f), shape = RoundedCornerShape(16.dp))
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        BrushSizeSelector(onBrushSizeSelected)
        Spacer(modifier = Modifier.width(16.dp))
        BrushColorSelector(onColorSelected)
        Spacer(modifier = Modifier.width(16.dp))
        EraserButton{onColorSelected(Color.White)}
        Spacer(modifier = Modifier.width(16.dp))
        UndoButton(onUndo)
    }
}

@Composable
fun EraserButton(onEraserSelected: (Color) -> Unit) {
    IconButton(onClick = { onEraserSelected(Color.White) }) { // Assuming the background is white
        Icon(
            painter = painterResource(id = R.drawable.ic_erase),
            contentDescription = "Eraser"
        )
    }
}

@Composable
fun UndoButton(onUndo : () -> Unit){
    IconButton(onClick = {onUndo()}){
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = "Undo"
        )
    }
}

@Composable
fun SaveButton(onSave: () -> Unit) {
    IconButton(onClick = { onSave() }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_export),
            contentDescription = "Save"
        )
    }
}

@Composable
fun ImportButton(onImport: () -> Unit) {
    IconButton(onClick = { onImport() }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_import),
            contentDescription = "Import"
        )
    }
}

@Composable
fun BrushSizeSelector(onBrushSizeSelected: (Float) -> Unit) {
    var showOptions by remember { mutableStateOf(false) }

    Box(contentAlignment = Alignment.Center) {
        IconButton(onClick = { showOptions = !showOptions }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_brush),
                contentDescription = "Select Brush Size"
            )
        }

        if (showOptions) {
            Popup(
                alignment = Alignment.TopCenter,
                onDismissRequest = { showOptions = false }
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    listOf(
                        Pair(R.drawable.ic_small_small_brush, 5f),
                        Pair(R.drawable.ic_small_brush, 10f),
                        Pair(R.drawable.ic_medium_small_brush, 15f),
                        Pair(R.drawable.ic_medium_brush, 20f),
                        Pair(R.drawable.ic_medium_large, 25f),
                        Pair(R.drawable.ic_large_brush, 30f)
                    ).forEach { (icon, size) ->
                        BrushSizeButton(icon, size) { selectedSize ->
                            onBrushSizeSelected(selectedSize)
                            showOptions = false
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun BrushSizeButton(iconRes: Int, size: Float, onClick: (Float) -> Unit) {
    IconButton(onClick = { onClick(size) }) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = "Brush size"
        )
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DrawingCanvas(brushSize: Float,
                  brushColor: Color,
                  drawingViewState: MutableState<DrawingView?>
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
            .border(0.5.dp, Color.LightGray)
    ) {
        AndroidView(
            factory = { context ->
                val drawingView = DrawingView(context, null)
                drawingView.setSizeForBrush(brushSize)
                drawingView.setColor(brushColor)
                drawingViewState.value = drawingView
                drawingView
            },
            update = {
                it.setSizeForBrush(brushSize)
                it.setColor(brushColor)
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}
