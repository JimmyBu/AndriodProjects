package com.jimmy.shoppinglist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val freeScriptFontFamily = FontFamily(
    Font(R.font.freestyle)
)

data class ShoppingItem(var id:Int,
                        var name:String,
                        var quantity:Int,
                        var isEditing:Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingListApp(){
    var sItems by remember { mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }

    Column (
        modifier = Modifier.fillMaxSize().systemBarsPadding().background(Color(0xFFF4F4F9)),
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {showDialog = true},
            modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 16.dp)
        ) {

            Text("Add Item",
                style = TextStyle(
                    fontFamily = freeScriptFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color(0xFF333333)
                ))
        }
        LazyColumn (
            modifier = Modifier.fillMaxSize().padding(16.dp),
        ) {
            items(sItems){
                item ->
                if(item.isEditing){
                    ShoppingItemEditor(item = item, onEditComplete = {
                        editedName, editedQuantity ->
                        sItems = sItems.map{it.copy(isEditing = false)}
                        val editedItem = sItems.find{it.id == item.id}
                        editedItem?.let {
                            it.name = editedName
                            it.quantity = editedQuantity
                        }
                    })
                }else{
                    ShoppingListItems(item = item, onEditClick = {
                        sItems = sItems.map{it.copy(isEditing = it.id == item.id)}
                        // find out which item you are editing and changing isEditing status
                    }, onDeleteClick = {
                        sItems = sItems-item
                    })
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(onDismissRequest = {showDialog = false},
            confirmButton = {
                Row(modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Button(onClick = {
                        if (itemName.isNotBlank()){
                            val newItem = ShoppingItem(
                                id = sItems.size+1,
                                name = itemName,
                                quantity = itemQuantity.toInt(),
                            )
                            sItems += newItem
                            showDialog = false
                            itemName = ""
                            itemQuantity = ""
                        }
                    }){
                        Text("Add",
                            style = TextStyle(
                                fontFamily = freeScriptFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color(0xFF333333)
                            ))
                    }

                    Button(onClick = {
                        showDialog = false
                    }){
                        Text("Cancel",
                            style = TextStyle(
                                fontFamily = freeScriptFontFamily,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color(0xFF333333)
                            ))
                    }
                }
            },
            title = {Text("Add Shopping Item", style = TextStyle(
                fontFamily = freeScriptFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp,
                color = Color(0xFF830E2D)
            ))},
            text = {
                Column{
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = {itemName = it},
                        singleLine = true,
                        label = { Text("Item Name", style = TextStyle(
                            fontFamily = freeScriptFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color(0x3F3C3CFF)
                            ))},
                        modifier = Modifier.fillMaxWidth().padding(8.dp).background(Color.White, RoundedCornerShape(12.dp)).border(4.dp, Color.DarkGray, RoundedCornerShape(12.dp)).padding(top = 5.dp),
                        textStyle = TextStyle(
                            fontFamily = freeScriptFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            color = Color(0xFF333333)
                            ),
                        shape = RoundedCornerShape(12.dp)
                        )

                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = {itemQuantity = it},
                        singleLine = true,
                        label = { Text("Quantity", style = TextStyle(
                            fontFamily = freeScriptFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color(0x3F3C3CFF)
                        )) },
                        modifier = Modifier.fillMaxWidth().padding(8.dp).background(Color.White, RoundedCornerShape(12.dp)).border(4.dp, Color.DarkGray, RoundedCornerShape(12.dp)).padding(top = 5.dp),
                        textStyle = TextStyle(
                            fontFamily = freeScriptFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            color = Color(0xFF333333)
                            ),
                        shape = RoundedCornerShape(12.dp)
                    )
                }
            }
            )


    }
}

@Composable
fun ShoppingItemEditor(item: ShoppingItem,
                       onEditComplete: (String, Int) -> Unit,
                       ){
    var editedName by remember { mutableStateOf(item.name) }
    var editedQuantity by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }


    Row (
        modifier = Modifier.fillMaxWidth().background(Color.Transparent).padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            BasicTextField(
                value = editedName,
                onValueChange = { editedName = it },
                singleLine = true,
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color(0xFFF4F4F9), RoundedCornerShape(8.dp)),
                textStyle = TextStyle(
                    fontFamily = freeScriptFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFF333333)
                )
            )


            BasicTextField(
                value = editedQuantity,
                onValueChange = { editedQuantity = it },
                singleLine = true,
                modifier = Modifier
                    .padding(4.dp)
                    .background(Color(0xFFF4F4F9), RoundedCornerShape(8.dp)),
                textStyle = TextStyle(
                    fontFamily = freeScriptFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFF333333)
                )
            )

        }

        Button (
            onClick = {
                isEditing = false
                onEditComplete(editedName, editedQuantity.toIntOrNull() ?: 1)
            },
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text("Save", style = TextStyle(
                fontFamily = freeScriptFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                color = Color(0xFF333333)
            ))
        }
    }
}


@Composable
fun ShoppingListItems(
    item: ShoppingItem,
    onEditClick: () -> Unit, // Lambda Function
    onDeleteClick: () -> Unit,
){
    Row(
        modifier = Modifier.padding(8.dp).fillMaxWidth().border(
            border = BorderStroke(2.dp, Color(0xFF0A8A89)),
            shape = RoundedCornerShape(12.dp)
        ).background(Color.White, RoundedCornerShape(12.dp)),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(text = item.name,
            modifier = Modifier.padding(8.dp).weight(1f).align(Alignment.CenterVertically),
            style = TextStyle(
                fontFamily = freeScriptFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                color = Color(0xFF333333)
            )
        )
        Text(text = "Qty: ${item.quantity}",
            modifier = Modifier.padding(8.dp).align(Alignment.CenterVertically),
            style = TextStyle(
                fontFamily = freeScriptFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(0xFF333333)
            ),
        )
        Row(modifier = Modifier.padding(8.dp)){
            IconButton(onClick = onEditClick) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null, tint = Color(0xFF0A8A89))
            }

            IconButton(onClick = onDeleteClick) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = Color(0xFFE74C3C))
            }
        }
    }
}
