package com.example.wargame;


import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class Card {
    private Random rnd = new Random();
    private int rndNum;
    private ImageView IV;
    private int value;
    private int suit; // 0 = c, 1 = d, 2 = h, 3 = s, 4 = j



    public Card(ImageView IV){
        this.IV = IV;
        this.rndNum = rnd.nextInt(55);
        change();
    }

    public Card(Card c){
        this.IV = c.IV;
        this.rndNum = rnd.nextInt(55);
        this.value = c.value;
        this.suit = c.suit;
    }


    public int getRndNum() {
        return rndNum;
    }

    public void changeRND(){
        this.rndNum = rnd.nextInt(55);
    }

    public void change(){
        this.value = rnd.nextInt(12) + 2;
        this.suit = rnd.nextInt(5);
    }

    public void restart(){
        IV.setImageResource(R.drawable.back);
        this.change();
    }

    public int checkCard(Card c){ // 1 = bigger, 2 = equals, 3 = smaller
        if(this.suit == 4){
            if(c.suit == 4) return 2;
            if(c.suit != 4) return 1;
        }
        if(c.suit == 4 && this.suit != 4) return 3;

        if(this.value == c.value) return 2;
        if(this.value > c.value) return 1;
        return 3;
    }

    public ImageView getIV(){
        return IV;
    }


    public void flip(View view, Resources res, String pac){
        this.change();
        String mDrawableName = "";
        // 0 = c, 1 = d, 2 = h, 3 = s, 4 = j
        if(this.suit == 0) mDrawableName += "c";
        else if(this.suit == 1) mDrawableName += "d";
        else if(this.suit == 2) mDrawableName += "h";
        else if(this.suit == 3) mDrawableName += "s";

        if(this.suit == 4) {
            mDrawableName += "j";
            if(this.value > 1) mDrawableName += "r";
            else mDrawableName += "b";
        }
        else{
            if(this.value == 10) mDrawableName += "a";
            else if(this.value == 11) mDrawableName += "j";
            else if(this.value == 12) mDrawableName += "q";
            else if(this.value == 13) mDrawableName += "k";
            else mDrawableName = mDrawableName + (this.value);
        }

        int resID = res.getIdentifier(mDrawableName , "drawable", pac);
        Drawable drawable = res.getDrawable(resID);
        IV.setImageDrawable(drawable);
    }

}
