package com.example.imtiazaminsajid.flyingbird;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {

    private int canvasWidth;
    private int canvasHeight;

    //private Bitmap bird;
    private Bitmap bird[] = new Bitmap[2];
    private int birdX = 10;
    private int birdY;
    private int birdSpeed;

    //Blue ball
    private int blueX;
    private int blueY;
    private int blueSpeed = 15;
    private Paint bluePaint = new Paint();

    //Black Ball
    private int blackX;
    private int blackY;
    private int blackSpeed = 20;
    private Paint blackPaint = new Paint();

    private Bitmap background;

    private Paint scorePaint = new Paint();
    private int score;

    private Paint levelPaint =  new Paint();

    private Bitmap life[] = new Bitmap[2];

    private boolean touch_flg = false;

    public GameView(Context context) {
        super(context);

        bird[0] = BitmapFactory.decodeResource(getResources(), R.drawable.bird1);
        bird[1] = BitmapFactory.decodeResource(getResources(), R.drawable.bird1);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);

        bluePaint.setColor(Color.BLUE);
        bluePaint.setAntiAlias(false);

        blackPaint.setColor(Color.BLACK);
        blackPaint.setAntiAlias(false);

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

        birdY = 500;

        score = 0;

    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvasWidth = canvas.getWidth();
        canvasHeight = canvas.getHeight();

        canvas.drawBitmap(background, 0,0,null);

        int minBirdY = bird[0].getHeight();
        int maxBirdY = canvasHeight - bird[0].getHeight()*3;

        birdY += birdSpeed;
        if (birdY<minBirdY)birdY = minBirdY;
        if (birdY>maxBirdY)birdY = maxBirdY;
        birdSpeed +=2;

        if (touch_flg){

            canvas.drawBitmap(bird[1], birdX, birdY, null);
            touch_flg = false;
            }
            else {
            canvas.drawBitmap(bird[0], birdX, birdY, null);
        }


        //Blue Ball

        blueX -=blueSpeed;

        if (hitCheck(blueX, blueY)){

            score +=10;
            blueX = -100;

        }

        if (blueX<0){
            blueX = canvasWidth + 20;
            blueY = (int)  Math.floor(Math.random() * (maxBirdY - minBirdY)) + minBirdY;
        }

        canvas.drawCircle(blueX, blueY, 12, bluePaint);


        //Black Ball

        blackX -= blackSpeed;
        if (hitCheck(blackX, blackY)){
            blackX = -100;
        }
        if (blackX < 0){
            blackX = canvasWidth + 200;
            blackY = (int)  Math.floor(Math.random() * (maxBirdY - minBirdY)) + minBirdY;
        }
        canvas.drawCircle(blackX, blackY, 20, blackPaint);




        canvas.drawText("Score : " + score,20, 60, scorePaint);

        canvas.drawText("Lv.1", canvasWidth / 2, 60, levelPaint);

        canvas.drawBitmap(life[0],560,30,null);
        canvas.drawBitmap(life[0],620,30,null);
        canvas.drawBitmap(life[1],680,30,null);
    }

    public boolean hitCheck(int x, int y){

        if (birdX < x && x < (birdX + bird[0].getWidth()) &&
                birdY < y && y < (birdY + bird[0].getHeight())) {
            return true;
        }

        return false;

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
            touch_flg = true;
            birdSpeed= -20;
        }
        return true;
    }
}
