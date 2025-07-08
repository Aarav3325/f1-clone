package com.aarav.f1clone.ui.circuit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.aarav.f1clone.ui.circuit.ui.theme.F1CloneTheme
import com.aarav.f1clone.ui.circuit.ui.theme.formula
import com.aarav.f1clone.ui.raceinfo.RaceViewModel

class CircuitActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            F1CloneTheme {

                val roundNumber = intent.getStringExtra("roundNumber");

                val raceViewModel = ViewModelProvider(this).get(RaceViewModel::class.java)

                val racesList by raceViewModel.races.observeAsState()
                Log.i("MYTAG","Races : " + racesList?.size)

                Log.i("ROUND", roundNumber.toString())

                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
                            title = { Text(text = "Race Details", fontFamily = formula, fontWeight = FontWeight.Normal, color = Color.White) },
                            navigationIcon = {
                                IconButton(
                                    onClick = {
                                        finish()
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = null,
                                        tint = Color.White
                                    )
                                }
                            }
                        )
                    },
                    containerColor = Color.Black
                    ) {
                    CircuitInfoScreen(modifier = Modifier.padding(it), raceViewModel, roundNumber)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    F1CloneTheme {
        Greeting("Android")
    }
}