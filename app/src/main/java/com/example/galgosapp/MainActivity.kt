package com.example.galgosapp

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.runtime.MutableState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.galgosapp.ui.theme.GalgosAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GalgosAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    InterfazdeInicio()
                }
            }
        }
    }
}

@Composable
fun InterfazdeInicio() {
    var noControl by remember { mutableStateOf("")}
    var contrasena by remember { mutableStateOf("")}
    var logo = R.drawable.logo_tec
    var showDialog by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image( painter = painterResource(logo), contentDescription = "Logo" )
        IntroduccionDatos(
            label = R.string.noControl,
           //leadingIcon = R.drawable.money,
            keyboardOptions  = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = noControl,
            onValueChanged = {noControl = it},
            modifier = Modifier.padding(bottom = 32.dp)
        )
        IntroduccionDatos(
            label = R.string.contrasena,
            //leadingIcon = androidx.core.R.drawable.notification_action_background,
            keyboardOptions  = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            value = contrasena,
            onValueChanged = {contrasena = it},
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(bottom = 30.dp)
        ) {
            Button(
                onClick = {showDialog = true}
            ){
                Text(text = "Recuperar contraseña")
            }
            Button(
                onClick = {showDialog = true}
            ){
                Text(text = "Ingresar")
            }
        }
        Text(
            text = "Powered by SPL Group ", fontSize = 10.sp
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroduccionDatos(
    @StringRes label: Int,
    //@DrawableRes leadingIcon : Int,
    keyboardOptions: KeyboardOptions,
    value : String,
    onValueChanged : (String) -> Unit,
    modifier: Modifier = Modifier
){
    TextField(
        value = value,
        onValueChange =onValueChanged ,
        singleLine = true,
        //leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        modifier = modifier,
        label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun Botones(){

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GalgosAppTheme {
        InterfazdeInicio( )
    }
}