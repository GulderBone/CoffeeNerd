package com.gulderbone.coffeenerd.intro

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gulderbone.coffeenerd.R
import com.gulderbone.core.presentation.designsystem.components.CoffeeNerdOutlinedActionButton

@Composable
fun IntroScreenRoot(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit,
) {
    IntroScreen(
        onAction = {
            when (it) {
                IntroAction.SignUp -> onSignUpClick()
                IntroAction.SignIn -> onSignInClick()
            }
        }
    )
}

@Composable
fun IntroScreen(onAction: (IntroAction) -> Unit) {
    com.gulderbone.core.presentation.designsystem.components.GradientBackground {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(bottom = 48.dp),
        ) {
            Text(
                text = stringResource(R.string.welcome_to_coffee_nerd),
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.coffe_nerd_description),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(modifier = Modifier.height(12.dp))
            CoffeeNerdOutlinedActionButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = stringResource(id = R.string.sign_in),
                isLoading = false,
                onClick = { onAction(IntroAction.SignIn) }
            )
            CoffeeNerdOutlinedActionButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = stringResource(id = R.string.sign_up),
                isLoading = false,
                onClick = { onAction(IntroAction.SignUp) }
            )
        }
    }
}

sealed interface IntroAction {
    data object SignUp : IntroAction
    data object SignIn : IntroAction
}

@Preview(name = "Light Theme", heightDp = 480, widthDp = 360)
@Composable
private fun IntroScreenPreview() {
    com.gulderbone.core.presentation.designsystem.CoffeeNerdTheme {
        IntroScreen(
            onAction = {}
        )
    }
}

@Preview(name = "Dark Theme", heightDp = 480, widthDp = 360, uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun IntroScreenPreviewDark() {
    com.gulderbone.core.presentation.designsystem.CoffeeNerdTheme {
        IntroScreen(
            onAction = {}
        )
    }
}