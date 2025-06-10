package com.zurie.ejemplo1composeridgs903

import android.annotation.SuppressLint
import android.app.Person
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


private val tarjetas:List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku","El protagonista de la serie, conocido por su gran poder y personalidad amigable."),
    PersonajeTarjeta("Vegeta","Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters."),
    PersonajeTarjeta("Piccolo","Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación."),
    PersonajeTarjeta("Bulma","Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("Freezer","Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("Celula","Cell conocido como Célula en España, es un bioandroide creado por la computadora del Dr. Gero, quien vino del futuro de la línea 3 con la intención de vengarse de Goku."),
    PersonajeTarjeta("Krillin","Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball."),
    PersonajeTarjeta("Trunks","Hijo de Vegeta y Bulma. Es un mestizo entre humano terrícola y Saiyano nacido en la Tierra, e hijo de Bulma y Vegeta"),
    PersonajeTarjeta("Master Roshi","Maestro de artes marciales y mentor de Goku."),
    PersonajeTarjeta("Majin Buu","También conocido como Boo original, es la forma original y pura de Majin-Boo, y la última forma de Boo que aparece en Dragon Ball Z.")
)
data class PersonajeTarjeta(val title: String, val body: String)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//Aqui se establece el tema, esto es desde que nosotros creamos el proyecto
        //se establece el tema y dentro nuestra funcion
        setContent {
            Ejemplo1ComposerIDGS903Theme {
                Tarjeta(tarjetas)
            }

        }
    }
}



@Composable
fun Personaje(name:String,color:Color,style:TextStyle){
    Text(text = name)
}
@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium)
        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyMedium)

    }
}
@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        //ImagenHeroe()
        items(personajes){ personaje ->
            MyPersonajes(personaje)
        }
    }

}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta){
    Card (
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
                .background(MaterialTheme.colorScheme.background)
        ) {
            ImagenHeroe()
            Personajes(personaje)
        }
    }
}
@Composable
fun ImagenHeroe(){
    Image(
        painter = painterResource(R.drawable.logo_dragonballapi),
        contentDescription ="Goku",
        modifier= Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.tertiary)//Asi se hace referencia del color respecto al tema
    )
}

@Preview
@Composable
fun GreetingPreview(){
    Tarjeta(tarjetas)
}


