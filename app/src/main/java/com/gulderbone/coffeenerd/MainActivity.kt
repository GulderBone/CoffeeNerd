package com.gulderbone.coffeenerd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.gulderbone.coffeenerd.intro.IntroScreenRoot
import com.gulderbone.coffeenerd.ui.theme.CoffeeNerdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoffeeNerdTheme {
                IntroScreenRoot(onSignUpClick = { /*TODO*/ }) {

                }
            }
        }
    }
}