package com.example.ladm_u3_ejercicio7

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import java.lang.Math.random
import kotlin.math.roundToInt
import kotlin.random.Random

class Circulo (l: Lienzo,X:Float,Y:Float)
{
    val l=l
    var X=X
    var Y=Y
    var movx=0f
    var movy=0f
    var color= Color.BLACK

    init
    {
        this.X=(l.height+20).toFloat()
        this.Y=(l.height+20).toFloat()
        movx=rand(6)+2
        movy=rand(6)+2
        color=Color.rgb((random()*255).roundToInt(), (random()*255).roundToInt(), (random()*255).roundToInt())
    }
    private fun rand(inp:Int):Float
    {
        return Random.nextInt(inp).toFloat()
    }
    fun mover()
    {
        X+=movx
        Y+=movy
        if(X>l.width &&movx>0)  {movx*=-1}
        else if(X<0&&movx<0)    {movx*=-1}
        if(Y>l.height &&movy>0)  {movy*=-1}
        else if(Y<0&&movy<0)    {movy*=-1}
    }
    fun pintar(canvas: Canvas)
    {
        var p= Paint()
        p.color=color
        canvas.drawCircle(X,Y,50f,p)
    }
}