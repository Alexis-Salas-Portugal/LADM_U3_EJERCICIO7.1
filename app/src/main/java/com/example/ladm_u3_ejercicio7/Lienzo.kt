package com.example.ladm_u3_ejercicio7

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Lienzo(este:MainActivity): View(este)
{
    val este=este
    val circulos= mutableListOf<Circulo>(Circulo(this,100f,200f))
    val crtn=GlobalScope.launch{
        click(this@Lienzo)
        while(true)
        {
            este.runOnUiThread()
            {
                invalidate()
            }
            delay(10)
        }
    }
    override fun onDraw(c: Canvas)
    {
        super.onDraw(c)
        val p=Paint()
        c.drawColor(Color.BLACK)
        for(circ in circulos)
        {
            //pipo pipo pipo
            circ.mover()
            circ.pintar(c)
        }
    }
    fun click(lie:Lienzo)
    {
        var xc=0f
        var yc=0f

        lie.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                xc = event.x.toFloat()
                yc = event.y.toFloat()
                circulos.add(Circulo(this,xc,yc))
            }
            invalidate()
            true
        })
    }
}