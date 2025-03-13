package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirlineStops
import androidx.compose.material.icons.filled.AlignVerticalCenter
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.CurrencyYuan
import androidx.compose.material.icons.filled.Height
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Tag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen(modifier: Modifier = Modifier) {
    var ageState = remember {
        mutableStateOf("Age")
    }

    var weightState = remember {
        mutableStateOf("Weight")
    }

    var heightState = remember {
        mutableStateOf("Height")
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),

    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF42A9D9),
                            Color(0xFF6450C0),
                            Color(0xFFE03D71),
                        )
                    )
                )
        ){
            Text(
                text = stringResource(
                    R.string.hi
                ),
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier
                    .padding(top= 32.dp)
                    .padding(30.dp)
                    .weight(1f)
            )
            Card (
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .weight(6f),

                shape = RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp
                ),

            ){
                Column (
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 30.dp),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Image(
                                painter = painterResource(
                                    R.drawable.boy
                                ),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(200.dp)
                                    .padding(
                                        top = 50.dp
                                    )
                            )
                            Button(onClick = {},
                                colors = ButtonDefaults.buttonColors(Color(0xFF42A9D9)),
                                modifier = Modifier
                                    .width(100.dp),



                                ){
                                Text(
                                    text = stringResource(
                                        R.string.male
                                    )
                                )
                            }
                        }
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Image(
                                painter = painterResource(
                                    R.drawable.woman
                                ),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(200.dp)
                                    .padding(
                                        top = 50.dp
                                    )
                            )

                            Button(onClick = {},
                                colors = ButtonDefaults.buttonColors(Color(0xFFE03D71)),
                                modifier = Modifier

                                    .width(100.dp
                                    )
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.female
                                    )
                                )
                            }

                        }
                    }
                    OutlinedTextField(
                        value =  ageState.value,
                        onValueChange = { it ->
                            ageState.value = it
                        },
                        shape = RoundedCornerShape(30.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Tag,
                                contentDescription = "",
                                tint = Color(0xFF126083)

                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            capitalization = KeyboardCapitalization.Words
                        )

                    )
                    OutlinedTextField(
                        value =  weightState.value,
                        onValueChange = {it ->
                            weightState.value = it
                        },

                        modifier = Modifier
                            .padding(top = 32.dp),
                        shape = RoundedCornerShape(30.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Balance,
                                contentDescription = "",
                                tint = Color(0xFF126083)

                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            capitalization = KeyboardCapitalization.Words
                        )

                    )
                    OutlinedTextField(
                        value =  heightState.value,
                        onValueChange = {it ->
                            heightState.value = it
                        },
                        modifier = Modifier
                            .padding(top = 32.dp),
                        shape = RoundedCornerShape(30.dp),
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Height,
                                contentDescription = "",
                                tint = Color(0xFF126083)

                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            capitalization = KeyboardCapitalization.Words
                        )
                    )
                    Button(onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFF7B3DE0)),
                        modifier = Modifier
                            .padding(32.dp)
                            .width(280.dp)
                            .height(50.dp)
                    ){
                        Text(
                            text = stringResource(R.string.calculate),
                            fontSize = 20.sp,

                        )
                    }

                }



            }

        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen()
}

