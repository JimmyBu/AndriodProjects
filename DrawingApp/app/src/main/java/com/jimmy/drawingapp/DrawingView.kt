package com.jimmy.drawingapp

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.toArgb


class DrawingView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var mDrawPath: CustomPath? = null
    private var mCanvasBitmap: Bitmap? = null
    private var mDrawPaint: Paint? = null
    private var mCanvasPaint: Paint? = null
    private var mBrushSize: Float = 10f
    private var color = Color.BLACK
    private var canvas: Canvas? = null
    private val mPaths = ArrayList<CustomPath>()
    private val mUndoPaths = ArrayList<CustomPath>()

    init {
        setUpDrawing()
    }

    private fun setUpDrawing() {
        mDrawPaint = Paint().apply {
            color = this@DrawingView.color
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            strokeCap = Paint.Cap.ROUND
        }
        mDrawPath = CustomPath(color, mBrushSize)
        mCanvasPaint = Paint(Paint.DITHER_FLAG)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mCanvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        canvas = Canvas(mCanvasBitmap!!)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.clipRect(0f, 0f, width.toFloat(), height.toFloat())
        canvas.drawBitmap(mCanvasBitmap!!, 0f, 0f, mCanvasPaint)

        // Draw previous paths
        for (path in mPaths) {
            mDrawPaint?.let {
                it.strokeWidth = path.brushThickness
                it.color = path.color
                canvas.drawPath(path, it)
            }
        }

        // Draw the current path
        mDrawPath?.let {
            if (!it.isEmpty) {
                mDrawPaint?.let { paint ->
                    paint.strokeWidth = it.brushThickness
                    paint.color = it.color
                    canvas.drawPath(it, paint)
                }
            }
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val touchX = event?.x
        val touchY = event?.y

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                mDrawPath = CustomPath(color, mBrushSize).apply {
                    reset()
                    if (touchX != null && touchY != null) {
                        moveTo(touchX, touchY)
                    }
                }

            }
            MotionEvent.ACTION_MOVE -> {
                mDrawPath?.let {
                    if (touchX != null && touchY != null) {
                        it.lineTo(touchX, touchY)
                    }
                }

            }
            MotionEvent.ACTION_UP -> {
                mDrawPath?.let {
                    mPaths.add(it)  // Save path before resetting
                }
                mDrawPath = CustomPath(color, mBrushSize)
            }
            else -> return false
        }

        invalidate()
        return true
    }

    fun setSizeForBrush(newSize: Float) {
        mBrushSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, newSize, resources.displayMetrics)
        mDrawPaint?.strokeWidth = mBrushSize
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun setColor(newColor: androidx.compose.ui.graphics.Color) {
        color = newColor.toArgb()
        mDrawPaint?.color = color
    }

    fun onClickUndo(){
        if(mPaths.size > 0){
            mUndoPaths.add(mPaths.removeAt(mPaths.size-1))
            invalidate() // call onDraw
        }
    }

    fun getDrawingBitmap(): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        draw(canvas)
        return bitmap
    }


    internal inner class CustomPath(var color: Int, var brushThickness: Float) : Path()
}
