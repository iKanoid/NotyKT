/*
 * Copyright 2020 Shreyas Patil
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shreyaspatil.noty.composeapp.component.text

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.shreyaspatil.noty.composeapp.ui.theme.getTextFieldHintColor

@Composable
fun NotyTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp,
    color: Color = MaterialTheme.colors.onPrimary,
    leadingIcon: @Composable() (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    OutlinedTextField(
        value = value,
        label = { Text(text = label) },
        modifier = modifier,
        onValueChange = onValueChange,
        leadingIcon = leadingIcon,
        textStyle = TextStyle(color, fontSize = fontSize),
        isError = isError,
        visualTransformation = visualTransformation
    )
}

@ExperimentalAnimationApi
@Composable
fun BasicNotyTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String = "",
    textStyle: TextStyle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal),
    onTextChange: (String) -> Unit,
    maxLines: Int = Int.MAX_VALUE
) {

    Box(modifier = modifier.padding(4.dp)) {
        AnimatedVisibility(visible = value.isBlank()) {
            Text(
                text = label,
                color = getTextFieldHintColor(),
                fontSize = textStyle.fontSize,
                fontWeight = textStyle.fontWeight
            )
        }
        BasicTextField(
            value = value,
            onValueChange = onTextChange,
            textStyle = textStyle.copy(color = MaterialTheme.colors.onPrimary),
            maxLines = maxLines,
            cursorBrush = SolidColor(MaterialTheme.colors.primary)
        )
    }
}
