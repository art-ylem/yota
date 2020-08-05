package com.example.yota;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CircleArcView extends View {

    private Context context;

    static private int DEFAULT_FIRST_COLOR = Color.BLUE;
    private static int DEFAULT_SECOND_COLOR = Color.RED;
    private static int DEFAULT_BG_COLOR = Color.GRAY;
    private static float DEFAULT_BORDER_WIDTH = 4.0f;
    private static float DEFAULT_ANGLE = 230f;

    private int firstColor = DEFAULT_FIRST_COLOR;
    private int secondColor = DEFAULT_SECOND_COLOR;
    private int bgColor = DEFAULT_BG_COLOR;
    private float borderWidth = DEFAULT_BORDER_WIDTH;
    private float angle = DEFAULT_ANGLE;

    private Paint paint = new Paint();

    public CircleArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setupAttributes(attrs);


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    private void setupAttributes(AttributeSet attrs) {
        // 6
        // Obtain a typed array of attributes
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CircleArcView,
                0, 0);

        // 7
        // Extract custom attributes into member variables
        angle = typedArray.getFloat(R.styleable.CircleArcView_angle_of_arc, DEFAULT_ANGLE);
        firstColor = typedArray.getInt(R.styleable.CircleArcView_first_color, DEFAULT_FIRST_COLOR);
        secondColor = typedArray.getInt(R.styleable.CircleArcView_second_color, DEFAULT_SECOND_COLOR);
        bgColor = typedArray.getInt(R.styleable.CircleArcView_bg_color, DEFAULT_BG_COLOR);
        borderWidth = typedArray.getDimension(R.styleable.CircleArcView_border_width, DEFAULT_BORDER_WIDTH);

        // 8
        // TypedArray objects are shared and must be recycled.
        typedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawArc(canvas);


    }

    private void drawArc(Canvas canvas) {
        paint.setColor(bgColor);
        paint.setStyle(Paint.Style.STROKE);
        final RectF oval = new RectF();
        oval.set(this.getLeft() + borderWidth / 2,
                this.getTop() + borderWidth / 2,
                this.getRight() - borderWidth / 2,
                this.getBottom() - borderWidth / 2);

        paint.setStrokeWidth(borderWidth);
        canvas.drawArc(oval, 0, 360, false, paint);


        int color1 = firstColor;
        int color2 = secondColor;
        paint.setShader(new LinearGradient(this.getRight(), this.getBottom(), this.getLeft(), this.getTop(), color2, color1, Shader.TileMode.MIRROR));
        paint.setPathEffect(new CornerPathEffect(borderWidth));
        canvas.drawArc(oval, 180, -angle, false, paint);
    }
}
