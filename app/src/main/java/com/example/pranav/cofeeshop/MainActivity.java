package com.example.pranav.cofeeshop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity=0;
    boolean iswippedcream =false;
    boolean ischocolate = false;

    CheckBox hasWipped;
    CheckBox hasChocolate;
    String name;
    EditText getstring;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasWipped = (CheckBox) findViewById(R.id.check);
        hasChocolate = (CheckBox) findViewById(R.id.check1);
        getstring =(EditText) findViewById(R.id.edit1);

    }


    public void increment(View view) {
        quantity+=1;
        if(quantity>100){
            quantity=100;
            Toast.makeText(getApplicationContext(),"Quantity is too much!!!",Toast.LENGTH_SHORT).show();
        }
        display(quantity);
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
        name = getstring.getText().toString();
        String pricemessage = "Name : "+ name ;
        pricemessage+="\n Wipped cream ? " + hasWipped.isChecked();
        pricemessage+="\n chocolate ? " + hasChocolate.isChecked();
        pricemessage+="\n price : " + calculateprice();
        pricemessage+="\n Thankyou!!!";
        String subject = "ORDER SUMMARY";

        Intent mail = new Intent(Intent.ACTION_SENDTO);
        mail.setData(Uri.parse(("mailto:")));
        mail.putExtra(mail.EXTRA_TEXT,pricemessage);
        mail.putExtra(mail.EXTRA_SUBJECT,subject);
        if(mail.resolveActivity(getPackageManager()) != null){
            startActivity(mail);
        }
    }

    private int calculateprice() {
        int pricepercup = 5;
        if(hasWipped.isChecked()){
            pricepercup+=1;
        }
        if(hasChocolate.isChecked()){
            pricepercup+=2;
        }
        return (quantity*pricepercup);
    }

    private void display(int i) {
        TextView quantitytext=(TextView) findViewById(R.id.text1);
        quantitytext.setText(""+i);
    }
   /* private void displayprice(int i) {
        TextView price=(TextView) findViewById(R.id.tex2);
        price.setText(NumberFormat.getCurrencyInstance().format(i));

    }*/

    public void reset(View view) {
        quantity=0;
        if (hasWipped.isChecked()){
            hasWipped.setChecked(false);
           hasWipped.setSelected(false);
        }
        if (hasChocolate.isChecked()){
            hasChocolate.setChecked(false);
           hasChocolate.setSelected(false);
        }
        getstring.setText("");
        display(quantity);
    }


    public void checkwippedcream(View view) {
        if(!hasWipped.isChecked())
        {
            hasWipped.setChecked(false);
            hasWipped.setSelected(false);
        }
        else {
            hasWipped.setChecked(true);
            hasWipped.setSelected(true);
        }
    }

    public void checkchocolate(View view) {
        if(!hasChocolate.isChecked())
        {
            hasChocolate.setChecked(false);
            hasChocolate.setSelected(false);
        }
        else {
            hasChocolate.setChecked(true);
            hasChocolate.setSelected(true);
        }
    }

}
