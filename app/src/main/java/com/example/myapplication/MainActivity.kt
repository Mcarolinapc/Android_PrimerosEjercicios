package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   MyConstraintLayout(modifier = Modifier.padding(innerPadding))
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

@Composable
fun MyConstraintLayout(modifier: Modifier = Modifier){
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxRed, boxYellow, boxGreen, boxCyan, boxMagenta) = createRefs()
        Box(modifier = Modifier.size(120.dp).background(Color.Red).constrainAs(boxRed){
            //esta linkat al top de la pantalla
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        })
        Box(modifier = Modifier.size(120.dp).background(Color.Yellow).constrainAs(boxYellow){
            //empieza al mismo del rojo
            start.linkTo(boxRed.start)
            //con esto ya referencia
            bottom.linkTo(boxRed.top)
        })
        Box(modifier = Modifier.size(120.dp).background(Color.Green).constrainAs(boxGreen
        ){
            start.linkTo(boxRed.start)
            top.linkTo(boxRed.bottom)

        })
        Box(modifier = Modifier.size(120.dp).background(Color.Cyan).constrainAs(boxCyan){
            top.linkTo(boxRed.top)
            end.linkTo(boxRed.start)

        })
        Box(modifier = Modifier.size(120.dp).background(Color.Magenta).constrainAs(boxMagenta){
            top.linkTo(boxRed.top)
            start.linkTo(boxRed.end)

        })
    }
}

@Composable
fun ColumnText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        // Primera fila
        Row(modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFEADDFF)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Text composable",
                    textAlign = TextAlign.Justify , fontWeight = FontWeight.Bold
                )
                Text(
                    "Displays text and follows the recommended Material Design guidelines.",
                    textAlign = TextAlign.Justify , modifier = Modifier.padding(10.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFD0BCFF)),
                //.border(2.dp, Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Image composable",
                    textAlign = TextAlign.Justify ,fontWeight = FontWeight.Bold
                )
                Text(
                    "Creates a composable that lays out and draws a given Painter class object.",
                    textAlign = TextAlign.Justify , modifier = Modifier.padding(10.dp)
                )
            }
        }

        // Segunda fila
        Row(modifier = Modifier.weight(1f)) { // hace que dividir el ancho en tamaño igual de cada columnna
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFB69DF8)),
                //.border(2.dp, Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Row composable",
                    textAlign = TextAlign.Justify ,fontWeight = FontWeight.Bold
                )
                Text(
                    "A layout composable that places its children in a horizontal sequence.",
                    textAlign = TextAlign.Justify,  modifier = Modifier.padding(10.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color(0xFFF6EDFF)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Column Composable",
                    textAlign = TextAlign.Justify , fontWeight = FontWeight.Bold
                )
                Text(
                    "A layout composable that places its children in a vertical sequence..",
                    textAlign = TextAlign.Justify , modifier = Modifier.padding(10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
       MyConstraintLayout()
    }
}