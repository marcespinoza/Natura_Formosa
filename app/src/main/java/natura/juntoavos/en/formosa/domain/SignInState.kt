package natura.juntoavos.en.formosa.domain

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)