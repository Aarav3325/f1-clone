package com.aarav.f1clone.ui.circuit

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.aarav.f1clone.domain.race.DateAndTime
import com.aarav.f1clone.ui.circuit.ui.theme.formula
import com.aarav.f1clone.ui.raceinfo.RaceViewModel
import com.aarav.f1clone.ui.result.ResultActivity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Preview(showBackground = true)
@Composable
fun CircuitInfoScreen(modifier: Modifier, raceViewModel: RaceViewModel, roundNumber : String?){

    val r = roundNumber?.toInt()
    val finalRoundNUmber = (r?.minus(1)).toString()

    val race by raceViewModel.getRaceDetails("1", finalRoundNUmber).observeAsState();
    Log.i("MYTAG", "JAP GP : " + race?.circuit?.circuitName)

    val result by raceViewModel.getRaceResult("20", "0").observeAsState()
    Log.i("BAH", "Result" + result?.size)

    val fp1 = race?.firstPractice
    val fp2 = race?.secondPractice
    val fp3 = race?.thirdPractice
    val quali = race?.qualifying
    val circuit = race?.circuit
    val raceDate = race?.getDate() ?: ""
    var fp1Date = ""
    var new  = ""
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    try {
        val date: Date? = inputFormat.parse(raceDate)
        if (date != null) {
            val day = SimpleDateFormat("dd", Locale.getDefault()).format(date)
            val month = SimpleDateFormat("MMM", Locale.getDefault()).format(date)

            // Use day and month as needed
//            println("Day: $day")
//            println("Month: $month")
            new = day + " " + month
            Log.i("MYTAG", day.toString())
            Log.i("MYTAG", month.toString())
        }
    } catch (e: ParseException) {
        e.printStackTrace()
    }


    race?.let {
        Column(
            modifier = modifier
                .background(Color.Black)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(vertical = 16.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "FORMULA 1 ${race?.raceName?.uppercase()}" ?: "",
                //text = "FORMULA 1 QATAR AIRWAYS BRITISH GRAND PRIX 2025",
                color = Color(0xFFEBEBEB),
                style = TextStyle(
                    lineHeight = 32.sp
                ),
                fontFamily = formula,
                fontWeight = FontWeight.W500,
                fontSize = 22.sp
            )


            Text(
                text = "SCHEDULE",
                color = Color(0xFFEBEBEB),
                fontFamily = formula,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp,
                modifier = Modifier.padding(top = 32.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            EventCard(fp1, fp2, fp3, quali, race?.date, race?.time, roundNumber)

            Spacer(modifier = Modifier.height(32.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Color(0xFFdd0706)
            ){

            }

            Spacer(modifier = Modifier.height(1.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp),
                color = Color(0xFFdd0706)
            ){

            }


            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "CIRCUIT",
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily =  formula,
                color = Color.White
            )


            Spacer(modifier = Modifier.height(36.dp))

            CircuitComponent("Circuit Name", circuit?.circuitName)

            Spacer(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray))

            Spacer(modifier = Modifier.height(18.dp))

            CircuitComponent("Locality", circuit?.location?.locality)

            Spacer(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray))

            Spacer(modifier = Modifier.height(18.dp))

            CircuitComponent("Country", circuit?.location?.country)

            Spacer(modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color.Gray))

            AsyncImage(
                model = "https://media.formula1.com/image/upload/c_fit,h_704/q_auto/v1740000000/content/dam/fom-website/2018-redesign-assets/Circuit%20maps%2016x9/Japan_Circuit.webp",
                contentDescription = "Circuit Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
        }
    } ?: Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun CircuitComponent(title : String, description : String?){
    Text(
        text = title,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily =  formula,
        color = Color.LightGray
    )

    Spacer(modifier = Modifier.height(18.dp))

    Text(
        text = description ?: "",
        fontSize = 24.sp,
        fontWeight = FontWeight.W600,
        fontFamily =  formula,
        color = Color.White
    )

    Spacer(modifier = Modifier.height(18.dp))



}


@Composable
fun EventCard(fp1 : DateAndTime?, fp2 : DateAndTime?, fp3 : DateAndTime?, quali : DateAndTime?, raceDate : String?, raceTime : String?, finalRoundNumber : String?){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.DarkGray.copy(alpha = 0.35f))
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            EventItem(fp1?.date, "PRACTICE 1", finalRoundNumber)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.outline)
            )

            EventItem(fp2?.date, "PRACTICE 2", finalRoundNumber)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.outline)
            )

            EventItem(fp3?.date, "PRACTICE 3", finalRoundNumber)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.outline)
            )

            EventItem(quali?.date, "QUALIFYING", finalRoundNumber)
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.outline)
            )

            EventItem(raceDate, "RACE", finalRoundNumber)

        }
    }
}

@Composable
fun EventItem(
    date : String?,
    eventName : String,
    roundNumber: String?
){

    var isFP by remember { mutableStateOf(false) }

    if(eventName.contains("PRACTICE")){
        isFP = true
    }

    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth().clickable{
                if(!isFP && eventName.contains("RACE")){
                    val intent = Intent(context, ResultActivity::class.java)
                    intent.putExtra("roundNumber", roundNumber)
                    context.startActivity(intent)
                    Toast.makeText(context, "Clicked on event item", Toast.LENGTH_SHORT).show()
                }
            }
            .height(60.dp)
            .padding(16.dp)
            ,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = date?.toString() ?: "",
            fontFamily = formula,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.White,
        )

        Spacer(modifier = Modifier.width(24.dp))

        Text(
            text = eventName,
            fontFamily = formula,
            fontWeight = FontWeight.W600,
            fontSize = 14.sp,
            color = Color.White,
            modifier = Modifier.weight(1.0f)
        )

        if(!isFP && eventName.contains("RACE")){
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = null,
                tint = Color.White
            )
        }

    }
}