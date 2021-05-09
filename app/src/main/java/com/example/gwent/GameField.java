package com.example.gwent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.Random;
import java.util.Stack;

public class GameField extends AppCompatActivity{
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        View decorView = getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

    }




    public class GameView extends View {
        private boolean firstTime = true;
        private boolean gameRunning = true;
        private Thread gameThread = null;
        private Paint paint;
        private Canvas canvas;
        private SurfaceHolder surfaceHolder;

        @SuppressLint("ResourceType")
        ImageButton unit = findViewById(R.drawable.card1);
        @SuppressLint("ResourceType")
        ImageButton unit2 = findViewById(R.drawable.card2);
        @SuppressLint("ResourceType")
        ImageButton cardhuman2 = findViewById(R.drawable.cardhuman2);
        @SuppressLint("ResourceType")
        ImageButton cardhuman3 = findViewById(R.drawable.cardhuman3);
        @SuppressLint("ResourceType")
        ImageButton cardhuman4 = findViewById(R.drawable.cardhuman4);
        @SuppressLint("ResourceType")
        ImageButton cardhuman5 = findViewById(R.drawable.cardhuman5);
        @SuppressLint("ResourceType")
        ImageButton cardhuman6 = findViewById(R.drawable.cardhuman6);

        ImageButton[] arraylist=new ImageButton[]{unit,unit2,cardhuman2,cardhuman3,cardhuman4,cardhuman5,cardhuman6};
        Random random = new Random();

        public GameView(Context context) {
            super(context);
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.card1);
            int h = bitmap.getHeight()/3;
            int w = bitmap.getWidth()/5;

            //Rect firstFrame = new Rect(0,0,163,144);
            //firstCard = new Sprite(10, 0, 0, 100, firstFrame, bitmap);

            //surfaceHolder = getHolder();
            //paint = new Paint();
        }
        private int viewWidth,viewHeight;
        private int EnemyPoints = 0;
        private int MyPoints = 0;

        private Sprite firstCard;

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);

            viewWidth = w;
            viewHeight = h;
        }
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawARGB(250, 127, 199, 255); // заливаем цветом
            Paint p = new Paint();
            p.setAntiAlias(true);
            p.setTextSize(55.0f);
            p.setColor(Color.WHITE);
            canvas.drawText(EnemyPoints +"", viewWidth - 100, 70, p);
            canvas.drawText(MyPoints +"", viewWidth - 100, 700,p);
            //firstCard.draw(canvas);
        }
        
    }


}