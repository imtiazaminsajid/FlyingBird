package com.example.imtiazaminsajid.flyingbird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class GameView extends View {

    private Bitmap bird;

    private Bitmap background;

    private Paint scorePaint = new Paint();

    private Paint levelPaint =  new Paint();

    private Bitmap life[] = new Bitmap[2];

    public GameView(Context context) {
        super(context);

        bird = BitmapFactory.decodeResource(getResources(), R.drawable.bird1);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);

        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(32);
        scorePaint.setTypeface(Typeface.DEFAULT_BOLD);
        scorePaint.setAntiAlias(true);

        levelPaint.setColor(Color.BLACK);
        levelPaint.setTextSize(32);
        levelPaint.setTypeface(Typeface.DEFAULT_BOLD);
        levelPaint.setTextAlign(Paint.Align.CENTER);
        levelPaint.setAntiAlias(true);

        life[0] = BitmapFactory.decodeResource(getResources(), R.drawable.heart2);
        life[1] = BitmapFactory.decodeResource(getResources(), R.drawable.heart);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawBitmap(background, 0,0,null);

        canvas.drawBitmap(bird, 0,0,null);

        canvas.drawText("Score : 0",20, 60, scorePaint);

        canvas.drawText("Lv.1", canvas.getWidth() / 2, 60, levelPaint);

        canvas.drawBitmap(life[0],560,30,null);
        canvas.drawBitmap(life[0],620,30,null);
        canvas.drawBitmap(life[1],680,30,null);
    }
}
