package com.aarav.f1clone.ui.result

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.aarav.f1clone.R
import com.aarav.f1clone.domain.result.RaceResult
import com.aarav.f1clone.domain.result.Result
import com.aarav.f1clone.ui.circuit.ui.theme.formula
import com.aarav.f1clone.ui.raceinfo.RaceViewModel

@Preview(showBackground = true)
@Composable
fun ResultScreen(modifier: Modifier, roundNumber: String){

    val context = LocalContext.current

    val raceViewModel: RaceViewModel = viewModel()

    var roundNumberInt = roundNumber.toInt();

    var round by remember { mutableStateOf(0) }

    var offset = 20

    if(roundNumberInt == 1){
        round = 0
    }
    else if(roundNumberInt == 2){
        round = 20
    }
    else if(roundNumberInt >= 4){
        round = ((roundNumberInt * 20) - 1) - offset
    }
    else if(roundNumberInt == 3){
        round = 40
    }

    val r = roundNumber.toInt()
    val finalRoundNUmber = (r.minus(1)).toString()

    val race by raceViewModel.getRaceDetails("1", finalRoundNUmber).observeAsState();


    val raceResult by raceViewModel.getRaceResult("20", round.toString()).observeAsState()

    //Log.i("RESULT", "SIZE : " + raceResult?.size)

    Column(
        modifier = modifier.fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        race?.let {  Text(
            text = "FORMULA 1 ${race?.raceName?.uppercase()}" ?: "",
            // text = "FORMULA 1 QATAR AIRWAYS BRITISH GRAND PRIX 2025",
            color = Color(0xFFEBEBEB),
            style = TextStyle(
                lineHeight = 32.sp
            ),
            fontFamily = formula,
            fontWeight = FontWeight.ExtraLight,
            fontSize = 18.sp
            ) }

        Text(
            text = "RESULT",
            color = Color(0xFFEBEBEB),
            fontFamily = formula,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp,
            modifier = Modifier.padding(top = 32.dp)
        )


        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth().height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "POS.",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.weight(0.25f)
            )

            Text(
                text = "DRIVER",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.weight(0.3f)
            )

            Text(
                text = "TIME/RETIRED",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.weight(0.3f)
            )


            Text(
                text = "PTS.",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }


        Spacer(modifier = Modifier.fillMaxWidth().height(1.5.dp).background(Color.Gray))
        Spacer(modifier = Modifier.height(0.dp).background(Color.Gray))

        val list = listOf(1,2,3,4,5,6,7,8,9,10)



        raceResult?.forEach {
            item ->
            val driverImage by raceViewModel.getDriverImage(item.number).observeAsState()
             driverImage?.let { ResultTableItem(item, driverImage, raceViewModel)
                 Spacer(modifier = Modifier.fillMaxWidth().padding(top = 4.dp).height(1.dp).background(Color.Gray))
             }
        }

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Composable
fun ResultTableItem(result : Result, driverImage: String?, viewModel: RaceViewModel){




    //Log.i("RESULT", "DRIVER IMAGE : " + driverImage")
    Row(
        modifier = Modifier.fillMaxWidth().height(60.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = result.position,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.weight(0.05f)
        )

            AsyncImage(
                model = driverImage,
                contentDescription = null,
                modifier = Modifier.size(54.dp).weight(0.2f)
            )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.weight(0.3f)
        ) {
            Text(
                text = result.driver?.familyName ?: "",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 4.dp)
            )

            Text(
                text = result.constructor.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier
            )
        }

        Text(
            text = result?.time?.time ?: "DNF",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.weight(0.3f)
        )


        Text(
            text = result.points,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}