@file:Suppress("OPT_IN_USAGE_FUTURE_ERROR")

package com.gulderbone.auth.presentation.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gulderbone.auth.domain.PasswordValidationState
import com.gulderbone.auth.domain.UserDataValidator
import com.gulderbone.auth.presentation.R
import com.gulderbone.core.presentation.designsystem.CheckIcon
import com.gulderbone.core.presentation.designsystem.CoffeeNerdDarkRed
import com.gulderbone.core.presentation.designsystem.CoffeeNerdGreen
import com.gulderbone.core.presentation.designsystem.CoffeeNerdTheme
import com.gulderbone.core.presentation.designsystem.CrossIcon
import com.gulderbone.core.presentation.designsystem.EmailIcon
import com.gulderbone.core.presentation.designsystem.Poppins
import com.gulderbone.core.presentation.designsystem.components.CoffeeNerdActionButton
import com.gulderbone.core.presentation.designsystem.components.CoffeeNerdOutlinedActionButton
import com.gulderbone.core.presentation.designsystem.components.CoffeeNerdPasswordTextField
import com.gulderbone.core.presentation.designsystem.components.CoffeeNerdTextField
import com.gulderbone.core.presentation.designsystem.components.GradientBackground
import com.gulderbone.core.presentation.designsystem.components.ScreenThemePreviews

@Composable
fun RegisterScreenRoot(
    onSignInClick: () -> Unit,
    onSuccessfulRegistration: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel(),
) {

    RegisterScreen(
        state = viewModel.state,
        onAction = viewModel::onAction
    )
}

@Composable
private fun RegisterScreen(
    state: RegisterState,
    onAction: (RegisterAction) -> Unit,
) {
    GradientBackground {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(vertical = 32.dp)
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.create_account),
                style = MaterialTheme.typography.headlineMedium,
            )
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = Poppins,
                        color = Color.Gray,
                    )
                ) {
                    append(stringResource(R.string.already_have_an_account) + " ")
                    pushStringAnnotation(
                        tag = "clickable_text",
                        annotation = stringResource(R.string.login)
                    )
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontFamily = Poppins,
                        )
                    ) {
                        append(stringResource(R.string.login))
                    }
                }
            }
            ClickableText(
                text = annotatedString,
                onClick = { offset ->
                    annotatedString.getStringAnnotations(tag = "clickable_text", start = offset, end = offset)
                        .firstOrNull()?.let {
                            onAction(RegisterAction.OnLoginClick)
                        }
                }
            )
            Spacer(modifier = Modifier.height(48.dp))
            CoffeeNerdTextField(
                state = state.email,
                startIcon = EmailIcon,
                endIcon = if (state.isEmailValid) {
                    CheckIcon
                } else {
                    null
                },
                hint = stringResource(R.string.example_email),
                title = stringResource(R.string.email),
                modifier = Modifier.fillMaxWidth(),
                additionalInfo = stringResource(R.string.must_be_valid_email),
                keyboardType = KeyboardType.Email,
            )
            Spacer(modifier = Modifier.height(16.dp))
            CoffeeNerdPasswordTextField(
                state = state.password,
                isPasswordVisible = state.isPasswordVisible,
                onTogglePasswordVisibility = { onAction(RegisterAction.OnTogglePasswordVisibilityClick) },
                hint = stringResource(R.string.password),
                title = stringResource(R.string.password),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.dp))
            PasswordRequirement(
                text = stringResource(
                    id = R.string.at_least_x_characters,
                    UserDataValidator.MIN_PASSWORD_LENGTH,
                ),
                isValid = state.passwordValidationState.hasMinLength,
            )
            Spacer(modifier = Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.at_least_one_number,),
                isValid = state.passwordValidationState.hasNumber,
            )
            Spacer(modifier = Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.contains_lowercase_character),
                isValid = state.passwordValidationState.hasLowerCaseCharacter,
            )
            Spacer(modifier = Modifier.height(4.dp))
            PasswordRequirement(
                text = stringResource(id = R.string.contains_uppercase_character),
                isValid = state.passwordValidationState.hasUpperCaseCharacter,
            )
            Spacer(modifier = Modifier.height(32.dp))
            CoffeeNerdOutlinedActionButton(
                text = stringResource(R.string.register),
                isLoading = state.isRegistering,
                enabled = state.canRegister,
                modifier = Modifier.fillMaxWidth(),
                onClick = { onAction(RegisterAction.OnRegisterClick) },
            )
        }
    }
}

@Composable
fun PasswordRequirement(
    text: String,
    isValid: Boolean,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (isValid) {
                CheckIcon
            } else {
                CrossIcon
            },
            contentDescription = null,
            tint = if (isValid) {
                CoffeeNerdGreen
            } else {
                CoffeeNerdDarkRed
            }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp,
        )
    }
}

@ScreenThemePreviews
@Composable
private fun RegisterScreenPreview(
) {
    CoffeeNerdTheme {
        RegisterScreen(
            state = RegisterState(
                passwordValidationState = PasswordValidationState(
                    hasMinLength = true,
                    hasNumber = true,
                    hasLowerCaseCharacter = true,
                    hasUpperCaseCharacter = false,
                ),
            ),
            onAction = {}
        )
    }
}