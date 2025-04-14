package com.jimmy.trello.reusefunction

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldStyle(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit
) {
    TextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(text = label, color = Color.LightGray) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.LightGray,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Black,
            unfocusedIndicatorColor = Color.LightGray,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.LightGray
        ),
        singleLine = true
    )
}
