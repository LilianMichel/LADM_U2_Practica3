package mx.edu.ittepic.ladm_u2_practica3

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var hilo : HiloControl?=null
    var jugador = 1
    var rondas = 1
    var detener = 1
    var dado1Puntos = 0
    var dado2Puntos = 0
    var puntosj1 = 0
    var puntosj2 = 0
    var puntosj3 = 0
    var puntosj4 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            hilo = HiloControl(this)
            hilo?.start()
            button.visibility = View.INVISIBLE
        }
    }
        fun numeroDado() : Int{
            return (1..6).random().toInt()
        }
    fun ganador(){
        var ptsFinal = ArrayList<Int>()

        ptsFinal.add(puntosj1)
        ptsFinal.add(puntosj2)
        ptsFinal.add(puntosj3)
        ptsFinal.add(puntosj4)

        var ganadorRondas = ""

        if (ptsFinal[0] == ptsFinal.max()){
            ganadorRondas = "EL GANADOR ES EL JUGADOR 1"
        }
        if (ptsFinal[1] == ptsFinal.max()){
            ganadorRondas = "EL GANADOR ES EL JUGADOR 2"
        }
        if (ptsFinal[2] == ptsFinal.max()){
            ganadorRondas = "EL GANADOR ES EL JUGADOR 3"
        }
        if (ptsFinal[3] == ptsFinal.max()){
            ganadorRondas = "EL GANADOR ES EL JUGADOR 4"
        }

        AlertDialog.Builder(this)
            .setTitle("GANADOR")
            .setMessage("FELICIDADES, "+ganadorRondas)
            .setPositiveButton("OK"){p,i->}
            .show()
    }

}
