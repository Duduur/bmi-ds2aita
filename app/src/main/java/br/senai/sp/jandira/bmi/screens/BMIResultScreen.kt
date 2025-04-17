package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculate
import br.senai.sp.jandira.bmi.model.BmiStatud
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.numberConvertToLocale
import java.util.Locale

@Composable
fun BMIResultScreen(navegacao: NavHostController?) {

    val context = LocalContext.current
    val userFile = context.getSharedPreferences("userFile", Context.MODE_PRIVATE)
    val userAge = userFile.getInt("user_age", 0)
    val userWeight = userFile.getFloat("user_weight", 0.0f)
    val userHeight = userFile.getFloat("user_height", 0.0f)

    //OBETER OS DADOS DO IMC DO USUARIO

    val result = bmiCalculate(
        userWeight.toInt(),
        userHeight.toDouble().div(100)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            Color(0xFF8922FF),
                            Color(0xFFBC4CEC),
                            Color(0xFF960DD0),
                        )
                    )
                )
        ) {
            Text(
                text = stringResource(
                    R.string.Result
                ),
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier
                    .padding(top = 12.dp)
                    .padding(20.dp)
            )
            Card(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .weight(6f),
                   shape = RoundedCornerShape(
                        topStart  = 30.dp,
                        topEnd = 30.dp
                    ),
                    colors = CardDefaults
                        .cardColors(
                            containerColor  = Color.White
                        ),
                ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .size(110.dp),
                        colors = CardDefaults
                            .cardColors(
                                containerColor  = Color.White
                            ),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 6.dp,
                            color = result.color
                        )

                    ) {
                        Column(
                            modifier = Modifier

                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = numberConvertToLocale(result.bmi.second),
                                fontSize = 30.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,
                                )
                        }

                    }
                    Text(
                        text = result.bmi.first,
                        fontSize = 20.sp,
                        fontWeight =  FontWeight.SemiBold,
                        modifier = Modifier
                            .padding(top = 20.dp)
                    )
                    Card(
                        modifier = Modifier
                            .padding(20.dp)
                            .height(100.dp)
                            .width(320.dp),
                    ) {
                        Row (
                            modifier = Modifier
                                .fillMaxSize(),

                        ){
                            Column (
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(R.string.age),
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userAge",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                            VerticalDivider(
                                modifier = Modifier
                                    .width(10.dp)
                            )
                            Column (
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.Weight
                                    ),
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userWeight",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                            VerticalDivider(
                                modifier = Modifier
                                    .width(1.dp)
                            )
                            Column (
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .weight(1f),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ){
                                Text(
                                    text = stringResource(
                                        R.string.Height
                                    ),
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "$userHeight",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ){
                        BmiLevel(
                            leftText = stringResource(R.string.underweight),
                            rightText = " < 18.5",
                            bulletColor = colorResource(R.color.light_blue),
                            background =
                            if (result.status == BmiStatud.UNDER_WEIGHT)
                                colorResource(R.color.light_blue)
                            else Color.Transparent
                        )
                        BmiLevel(
                            leftText = stringResource(R.string.normal),
                            rightText = " 18.6 - 24.9",
                            bulletColor = colorResource(R.color.light_green),
                            background =
                            if (result.status == BmiStatud.NORMAL)
                                colorResource(R.color.light_green)
                            else Color.Transparent
                        )


                        BmiLevel(
                            leftText = stringResource(R.string.overweight),
                            rightText = " 25.0 - 29.9",
                            bulletColor = colorResource(R.color.yellow),
                            background =
                            if (result.status == BmiStatud.OVERWEIGHT)colorResource(R.color.yellow)else Color.Transparent
                        )
                        BmiLevel(
                            leftText = stringResource(R.string.obesity1),
                            rightText = " 30.0 - 34.9",
                            bulletColor = colorResource(R.color.light_orange),
                            background =
                            if (result.status == BmiStatud.OBESITY_1)
                                colorResource(R.color.light_orange)
                            else Color.Transparent
                        )
                        BmiLevel(
                            leftText = stringResource(R.string.obesity2),
                            rightText = " 35.0 - 39.9",
                            bulletColor = colorResource(R.color.dark_orange),
                            background =
                            if (result.status == BmiStatud.OBESITY_2)
                                colorResource(R.color.dark_orange)
                            else Color.Transparent
                        )
                        BmiLevel(
                            leftText = stringResource(R.string.obesity3),
                            rightText = " > 40.0",
                            bulletColor = colorResource(R.color.light_red),
                            background =
                            if (result.status == BmiStatud.OBESITY_3)
                                colorResource(R.color.light_red)
                            else Color.Transparent
                        )


                    }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .width(350.dp)
                    )

                    Button(onClick = {
                        navegacao?.navigate("user_data")
                    },
                        colors = ButtonDefaults.buttonColors(Color(0xFF8922FF)),
                        modifier = Modifier
                            .padding(top = 25.dp)
                            .width(300.dp)
                            .height(50.dp),
                        shape = RoundedCornerShape(
                            topStart = 10.dp,
                            topEnd = 10.dp,
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
                        )
                    ){
                        Text(
                            text = stringResource(
                                R.string.new_calc
                            ),
                            fontSize = 25.sp
                        )
                    }

                }
            }
        }
    }
}

@Preview
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}