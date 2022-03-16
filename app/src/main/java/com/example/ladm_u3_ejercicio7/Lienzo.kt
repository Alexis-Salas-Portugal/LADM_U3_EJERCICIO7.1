package com.example.ladm_u3_ejercicio7

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(este:MainActivity): View(este)
{
    val este=este
    val circulos=Array<Circulo>(5, { Circulo(this) })

    val crtn=GlobalScope.launch{
        while(true)
        {
            este.runOnUiThread()
            {
                invalidate()
            }
            delay(100)
        }
    }
    override fun onDraw(c: Canvas)
    {
        super.onDraw(c)
        val p=Paint()
        c.drawColor(Color.BLACK)
        for(circ in circulos)
        {
            circ.mover()
            circ.pintar(c)
        }
    }
}