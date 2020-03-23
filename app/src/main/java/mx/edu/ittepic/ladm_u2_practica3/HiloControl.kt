package mx.edu.ittepic.ladm_u2_practica3

import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*


class HiloControl(p:MainActivity) : Thread() {
    var puntero = p
    var iniciar = false


    override fun run() {
        super.run()
        iniciar=true
        while (iniciar) {
            sleep(2000)
            puntero.runOnUiThread{
                if (puntero.jugador == 5) {
                    puntero.rondas++
                    puntero.jugador = 1
                    if (puntero.rondas == 5) {
                        puntero.finjuego.setText("SU JUEGO HA TERMINADO")
                        iniciar = false
                    }
                }
                if (puntero.rondas<=4) {
                    puntero.dado1Puntos = puntero.numeroDado()
                    puntero.dado2Puntos = puntero.numeroDado()
                    if (puntero.jugador == 1) {
                        puntero.ej1.setText("JUGANDO")
                        puntero.ej2.setText("EN ESPERA")
                        puntero.ej3.setText("EN ESPERA")
                        puntero.ej4.setText("EN ESPERA")
                        puntero.puntosj1 += puntero.dado1Puntos + puntero.dado2Puntos
                    }
                    if (puntero.jugador == 2) {
                        puntero.ej1.setText("EN ESPERA")
                        puntero.ej2.setText("JUGANDO")
                        puntero.ej3.setText("EN ESPERA")
                        puntero.ej4.setText("EN ESPERA")
                        puntero.puntosj2 += puntero.dado1Puntos + puntero.dado2Puntos
                    }
                    if (puntero.jugador == 3) {
                        puntero.ej1.setText("EN ESPERA")
                        puntero.ej2.setText("EN ESPERA")
                        puntero.ej3.setText("JUGANDO")
                        puntero.ej4.setText("EN ESPERA")
                        puntero.puntosj3 += puntero.dado1Puntos + puntero.dado2Puntos
                    }
                    if (puntero.jugador == 4) {
                        puntero.ej1.setText("EN ESPERA")
                        puntero.ej2.setText("EN ESPERA")
                        puntero.ej3.setText("EN ESPERA")
                        puntero.ej4.setText("JUGANDO")
                        puntero.puntosj4 += puntero.dado1Puntos + puntero.dado2Puntos
                    }

                    sleep(2000)
                    when(puntero.dado1Puntos){
                        1->{
                            puntero.dadouno.setImageResource(R.drawable.uno)
                        }
                        2->{
                            puntero.dadouno.setImageResource(R.drawable.dos)
                        }
                        3->{
                            puntero.dadouno.setImageResource(R.drawable.tres)
                        }
                        4->{
                            puntero.dadouno.setImageResource(R.drawable.cuatro)
                        }
                        5->{
                            puntero.dadouno.setImageResource(R.drawable.cinco)
                        }
                        6->{
                            puntero.dadouno.setImageResource(R.drawable.seis)
                        }
                    }
                    when(puntero.dado2Puntos){
                        1->{
                            puntero.dadodos.setImageResource(R.drawable.uno)
                        }
                        2->{
                            puntero.dadodos.setImageResource(R.drawable.dos)
                        }
                        3->{
                            puntero.dadodos.setImageResource(R.drawable.tres)
                        }
                        4->{
                            puntero.dadodos.setImageResource(R.drawable.cuatro)
                        }
                        5->{
                            puntero.dadodos.setImageResource(R.drawable.cinco)
                        }
                        6->{
                            puntero.dadodos.setImageResource(R.drawable.seis)
                        }
                    }
                    if (puntero.jugador==1){
                        puntero.ptsj1.setText("PUNTOS: "+puntero.puntosj1)
                    }
                    if (puntero.jugador==2){
                        puntero.ptsj2.setText("PUNTOS: "+puntero.puntosj2)
                    }
                    if (puntero.jugador==3){
                        puntero.ptsj3.setText("PUNTOS: "+puntero.puntosj3)
                    }
                    if (puntero.jugador==4){
                        puntero.ptsj4.setText("PUNTOS: "+puntero.puntosj4)
                    }
                    puntero.jugador++
                }
            }
        }

        puntero.runOnUiThread {
            puntero.ganador()
            puntero.button.visibility = View.VISIBLE
        }

    }
}