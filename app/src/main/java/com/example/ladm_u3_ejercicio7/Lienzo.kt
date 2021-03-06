package com.example.ladm_u3_ejercicio7

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class Lienzo(este:MainActivity): View(este)
{
    val este=este
    val circulos= mutableListOf<Circulo>(Circulo(this,100f,200f))

    val crtn=GlobalScope.launch{
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
            circ.mover()
            circ.pintar(c)
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean
    {
        return super.onTouchEvent(event)
        var xc=0f
        var yc=0f


        when(event.action)
        {
            MotionEvent.ACTION_DOWN->
            {
                circulos.add(Circulo(this,0f,0f))
                este.setTitle("hola")
            }
            MotionEvent.ACTION_UP->
            {

            }
            MotionEvent.ACTION_MOVE->
            {

            }
        }
    }
}