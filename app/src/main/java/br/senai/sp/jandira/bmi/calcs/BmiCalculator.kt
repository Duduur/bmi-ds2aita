package br.senai.sp.jandira.bmi.calcs

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.model.Bmi
import br.senai.sp.jandira.bmi.model.BmiStatud
import kotlin.math.pow

@Composable
fun bmiCalculate(weight: Int, height: Double): Bmi {
    var bmi = weight / height.pow(2) //conta do bmi

    when{
        bmi < 18.5 -> // aqui é q nem o if, quando o bmi for menor q 18.5 ent retornara oq esta abaixo
            return Bmi(
                color = colorResource((R.color.light_blue)),
                status = BmiStatud.UNDER_WEIGHT,
                bmi = Pair(stringResource(R.string.under_weight), bmi)
            )
        bmi >= 18.5 && bmi <25.0 ->
            return Bmi(
                color = colorResource((R.color.light_green)),
                status = BmiStatud.NORMAL,
                bmi = Pair(stringResource(R.string.normal_weight), bmi)
            )
        bmi >= 25.0 &&  bmi <30.0->
            return Bmi(
                color = colorResource((R.color.yellow)),
                status = BmiStatud.OVERWEIGHT,
                bmi = Pair(stringResource(R.string.over_weight), bmi)
            )
        bmi >= 30.0 &&  bmi <35.0->
            return Bmi(
                color = colorResource((R.color.light_orange)),
                status = BmiStatud.OBESITY_1,
                bmi = Pair(stringResource(R.string.class1_weight), bmi)
            )
        bmi >= 35.0 &&  bmi <40.0->
            return Bmi(
                color = colorResource((R.color.dark_orange)),
                status = BmiStatud.OBESITY_2,
                bmi = Pair(stringResource(R.string.class2_weight), bmi)
            )
        else ->
            return Bmi(
                color = colorResource((R.color.light_red)),
                status = BmiStatud.OBESITY_3,
                bmi = Pair(stringResource(R.string.class3_weight), bmi)
            )
    }
}