/*
 * Copyright 2022 Sergio Belda
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

package dev.sergiobelda.todometer.app.common.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.sergiobelda.todometer.app.common.designsystem.theme.Alpha.applyMediumEmphasisAlpha
import dev.sergiobelda.todometer.app.common.ui.values.SectionPadding
import dev.sergiobelda.todometer.common.designsystem.resources.images.Images
import dev.sergiobelda.todometer.common.designsystem.resources.images.icons.Close
import dev.sergiobelda.todometer.common.designsystem.resources.images.icons.Event
import dev.sergiobelda.todometer.common.designsystem.resources.images.icons.Schedule
import dev.sergiobelda.todometer.common.resources.TodometerResources
import dev.sergiobelda.todometer.common.ui.extensions.dateFormat
import dev.sergiobelda.todometer.common.ui.extensions.timeFormat

@Composable
fun DateTimeSelector(
    dateMillis: Long?,
    onDateClick: () -> Unit,
    onTimeClick: () -> Unit,
    onEnterDateTimeClick: () -> Unit,
    onClearDateTimeClick: () -> Unit,
) {
    if (dateMillis != null) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(Modifier.width(12.dp))
            ClickableField(
                onClick = onDateClick,
                text = dateMillis.dateFormat(),
                imageVector = Images.Icons.Event,
            )
            ClickableField(
                onClick = onTimeClick,
                text = dateMillis.timeFormat(),
                imageVector = Images.Icons.Schedule,
            )
            IconButton(onClick = onClearDateTimeClick) {
                Icon(
                    Images.Icons.Close,
                    TodometerResources.strings.clear,
                    tint = MaterialTheme.colorScheme.onSurface.applyMediumEmphasisAlpha(),
                )
            }
        }
    } else {
        Box(
            modifier = Modifier.height(Height).clickable(onClick = onEnterDateTimeClick),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = TodometerResources.strings.enterDateTime,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .padding(horizontal = SectionPadding)
                    .fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun ClickableField(
    onClick: () -> Unit,
    text: String,
    imageVector: ImageVector? = null,
) {
    TextButton(onClick = onClick) {
        imageVector?.let {
            Icon(
                it,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurface,
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

private val Height: Dp = 48.dp
