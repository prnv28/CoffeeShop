package com.example.pranav.cofeeshop;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decriment(View view) {
        quantity-=1;
        if(quantity<0) {
            quantity=0;
            Context context = getApplicationContext();
            CharSequence text = "Quantity is not valid!!!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        }
        else {
            display(quantity);
        }
    }

    public void setorder(View view) {
        display(quantity);
        displayprice(quantity*5);
    }

    private void displayprice(int i) {
        TextView price=(TextView) findViewById(R.id.tex2);
        price.setText(NumberFormat.getCurrencyInstance().format(i));

    }

    public void increment(View view) {
        quantity+=1;
        display(quantity);
    }

    private void display(int i) {
        TextView quantitytext=(TextView) findViewById(R.id.text1);
        quantitytext.setText(""+i);
    }

    public void reset(View view) {
        quantity=0;
        display(quantity);
        displayprice(5*quantity);
    }
}
