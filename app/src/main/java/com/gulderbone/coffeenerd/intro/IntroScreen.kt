package com.gulderbone.coffeenerd.intro

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gulderbone.coffeenerd.R
import com.gulderbone.coffeenerd.components.GradientBackground
import com.gulderbone.coffeenerd.components.OutlinedActionButton
import com.gulderbone.coffeenerd.ui.theme.CoffeeNerdTheme

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
    GradientBackground {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            CoffeeNerdLogo()
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
            OutlinedActionButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                text = stringResource(id = R.string.sign_in),
                isLoading = false,
                onClick = { onAction(IntroAction.SignIn) }
            )
            OutlinedActionButton(
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

@Composable
fun CoffeeNerdLogo() {
    Icon(
        imageVector = LogoIcon,
        contentDescription = "Logo",
        tint = MaterialTheme.colorScheme.onBackground
    )
}

sealed interface IntroAction {
    data object SignUp : IntroAction
    data object SignIn : IntroAction
}

val LogoIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = R.drawable.logo)

@Preview
@Composable
private fun IntroScreenPreview() {
    CoffeeNerdTheme {
        IntroScreen(
            onAction = {}
        )
    }
}