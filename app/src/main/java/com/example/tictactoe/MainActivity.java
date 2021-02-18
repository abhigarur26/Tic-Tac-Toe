package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;
    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    //0 - x
    //1 - o
    //2 - null
    int[][] winPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};



    public void tapPlayer(View view){
        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());

        if(gameActive != false) {
            if (gameState[tappedImage] == 2) {
                gameState[tappedImage] = activePlayer;
                if (activePlayer == 0) {
                    img.setRotation(-360f);
                    img.setImageResource(R.drawable.colorx);
                        img.animate().rotation(360f).setDuration(2000);
                    activePlayer = 1;
                    TextView notify = (TextView) findViewById(R.id.notify);
                    notify.setText("O's Turn - Tap to Play");
                } else {
                    img.setRotationY(-360f);
                    img.setImageResource(R.drawable.coloro);
                    img.animate().rotationY(360f).setDuration(2000);
                    activePlayer = 0;
                    TextView notify = (TextView) findViewById(R.id.notify);
                    notify.setText("X's Turn - Tap to Play");
                }

            }

        }
        for(int[] winPosition: winPositions){
            if(gameState[winPosition[0]]==gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]]
                    &&gameState[winPosition[0]] != 2){
                gameActive = false;

                    if (gameState[winPosition[0]] == 0) {
                        TextView notify = (TextView) findViewById(R.id.notify);
                        notify.setText("Player X won!! - Reset to Play");
                    } else {
                        TextView notify = (TextView) findViewById(R.id.notify);
                        notify.setText("Player O won!! - Reset to Play");
                    }

            }else{
                boolean gameOver = true;
                for(int counterState: gameState){
                    if(counterState == 2) gameOver = false;
                }
                if(gameOver){
                    TextView notify = (TextView) findViewById(R.id.notify);
                    notify.setText("Aree koi na Jeeta ! - Reset to Play");
                }
            }

            }
        }



    public void reset(View view){
        gameActive = true;
        activePlayer = 0;
        for(int i=0; i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

        TextView status = findViewById(R.id.notify);
        status.setText("X's Turn - Tap to play");

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
