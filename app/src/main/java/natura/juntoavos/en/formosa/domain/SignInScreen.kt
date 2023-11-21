package natura.juntoavos.en.formosa.domain

import natura.juntoavos.en.formosa.R
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import natura.juntoavos.en.formosa.ui.theme.OrangeNatura
import natura.juntoavos.en.formosa.ui.theme.PacificoFont

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
    Box (
        modifier = Modifier
            .background(OrangeNatura)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box (
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Image(painter = painterResource(id = R.drawable.logo_natura), contentDescription = "logo_natura")
                    Text(
                        text = "Junto a vos en Formosa",
                        textAlign = TextAlign.Center,
                        fontFamily = PacificoFont,
                        fontSize = 20.sp
                    )
                }
            }
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.BottomCenter
            ) {
                Button(
                    onClick = onSignInClick,
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White),

                ) {
                    Text(text = "Iniciar sesión",
                        color = OrangeNatura)
                }
            }
        }
    }
}

@Preview ( showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(null) {}
}