package natura.juntoavos.en.formosa.domain

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignInScreen(
    state: SignInState? = null,
    onSignInClick: () -> Unit = {}
) {
    val context = LocalContext.current
    LaunchedEffect(key1 = state?.signInError) {
        state?.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),

            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box (
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Bienvenid@ a la app de Natura Junto a vos en Formosa",
                textAlign = TextAlign.Center,
            )
        }
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = onSignInClick
            ) {
                Text(text = "Iniciar sesión")
            }
        }
    }
}

@Preview ( showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(null) {}
}