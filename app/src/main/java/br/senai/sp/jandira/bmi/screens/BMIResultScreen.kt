package br.senai.sp.jandira.bmi.screens

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
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun BMIResultScreen(modifier: Modifier = Modifier) {
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
                            brush = Brush.linearGradient(
                                listOf(
                                    Color(0xFF8922FF),
                                    Color(0xFF960DD0)
                                )
                            )
                        )

                    ) {
                        Column(
                            modifier = Modifier

                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "30,6",
                                fontSize = 30.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.Black,

                                )
                        }

                    }
                    Text(
                        text = stringResource(
                            R.string.Obesity
                        ),
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
                                    text = stringResource(
                                        R.string.age
                                    ),
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "50",
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
                                    text = "97 Kg",
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
                                        R.string.high
                                    ),
                                    fontSize = 20.sp
                                )
                                Text(
                                    text = "178 cm",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp)
                    ) { }
                    HorizontalDivider(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .width(350.dp)
                    )

                    Button(onClick = {},
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
    BMIResultScreen()
}