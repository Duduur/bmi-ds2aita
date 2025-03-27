package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable
fun HomeScreen(navegacao: NavHostController?) {

    val nameState = remember {
        mutableStateOf("")
    }
    // abrir ou fechar um arquivo do tipo SharedPreferences
    val context = LocalContext.current
    val userFile = context.getSharedPreferences("userFile", Context.MODE_PRIVATE)

    val editor = userFile.edit()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(
                        Color(0xFFEE9F32),
                        Color(0xFFECDA4C),
                        Color(0xFFC0CE35),
                    )
                )
            )
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Image(
                painter = painterResource(
                    R.drawable.treino
                ),
                contentDescription = "",
                modifier = Modifier
                    .padding(
                        top = 32.dp
                    )
            )

            Text(
                text = stringResource(
                    R.string.welcome
                ),
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                ),

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End

                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                top = 60.dp
                            )
                            .padding(
                                horizontal = 40.dp
                            )


                    ){
                        Text(
                            text =  stringResource(
                                R.string.your_name
                            ),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        TextField(
                            value = nameState.value,
                            onValueChange = { it ->
                                nameState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.PlayArrow,
                                    contentDescription = "",
                                    tint = Color.Black
                                )
                            },

                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                                capitalization = KeyboardCapitalization.Words
                            )

                        )

                    }
                    Button(
                        onClick = {
                            editor.putString("user_name", nameState.value)
                            editor.apply()
                            navegacao?.navigate("user_data")
                        },
                        colors = ButtonDefaults.buttonColors(Color(0xFF54732B)),
                            modifier = Modifier
                                .padding(horizontal = 20.dp)

                    ) {
                        Text(
                            text = stringResource(
                                R.string.next
                            )
                        )

                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(null)
}