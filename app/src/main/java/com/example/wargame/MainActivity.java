package com.example.wargame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Drawable[] imgs;
    Card[] cards;
    boolean clicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cards = new Card[2];
        cards[0] = new Card((ImageView)findViewById(R.id.IV_user_card));
        cards[1] = new Card((ImageView)findViewById(R.id.IV_computer_card));
        ((TextView)findViewById(R.id.TV_result)).setVisibility(View.INVISIBLE);

        clicked = false;



    }

    public void restart(View view){
        for(int i = 0; i < cards.length; i++){
            cards[i].restart();
            ((TextView)findViewById(R.id.TV_result)).setVisibility(View.INVISIBLE);
            clicked = false;
        }
    }

    public void flipAllCards(View view){
        if(!clicked) {
            for (int i = 0; i < cards.length; i++) {
                cards[i].flip(cards[i].getIV(), getResources(), getPackageName());
            }
            clicked = true;
            this.setResult(view);
        }
    }

    public void setResult(View view){
        TextView myAwesomeTextView = (TextView)findViewById(R.id.TV_result);
        ((TextView)findViewById(R.id.TV_result)).setVisibility(View.VISIBLE);
        if(cards[0].checkCard(cards[1]) == 1) myAwesomeTextView.setText("You Won!");
        if(cards[0].checkCard(cards[1]) == 2) myAwesomeTextView.setText("Tie!");
        if(cards[0].checkCard(cards[1]) == 3) myAwesomeTextView.setText("You Lost!");
    }


}