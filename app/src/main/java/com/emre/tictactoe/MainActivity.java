package com.emre.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int currentPlayer = 1;
    String winner = "";
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winState = {{0,1,2},{3,4,5},{6,7,8},{1,4,7},{2,5,8},{0,3,6},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View v){
        ImageView iv = (ImageView) v;
        int tag= Integer.parseInt(iv.getTag().toString());
        if(gameState[tag] == 2 && winner.equals(""))
        if(currentPlayer == 1){
            iv.setImageResource(R.drawable.red);
            iv.animate().alpha(1f).setDuration(200);//alpha 0f olursa 2ms  içinde opaklıgı 0 a ceker yanı görünürdenn siler
            gameState[tag]=currentPlayer;
            currentPlayer=0;
        }
        else if(currentPlayer == 0){
            iv.setImageResource(R.drawable.yellow);
            iv.animate().alpha(1f).setDuration(200);//alpha 0f olursa 2ms  içinde opaklıgı 0 a ceker yanı görünürdenn siler
            gameState[tag]=currentPlayer;

            currentPlayer=1;
        }
        Check();

    }

    private void Check() {

        for(int[] i:winState){
            if (gameState[i[0]]==gameState[i[1]]&&gameState[i[0]]==gameState[i[2]]&&gameState[i[0]]!=2){
                if(gameState[i[0]]==0){
                    winner= "YELLOW";

                }
                else{
                    winner = "RED";
                }
                Toast.makeText(this,"We have a winner " +winner,Toast.LENGTH_LONG).show();
            }
        }
    }
}