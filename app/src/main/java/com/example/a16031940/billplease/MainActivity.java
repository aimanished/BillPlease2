package com.example.a16031940.billplease;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText amount;
    EditText pax;
    ToggleButton Tn1;
    ToggleButton Tn2;
    Button split;
    Button reset;
    TextView seepax;
    TextView seeprice;
    double GSTONLY;
    double SVCONLY;
    double price;
    double payersSVC;
    double payersGST;
    double PAYBOTH;
    double mepek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        amount=(EditText) findViewById(R.id.A1);
        pax=(EditText) findViewById(R.id.P1);
        Tn1=(ToggleButton) findViewById(R.id.T1);
        Tn2=(ToggleButton) findViewById(R.id.T2);
        split=(Button)findViewById(R.id.S1);
        reset=(Button)findViewById(R.id.R1);
        seepax=(TextView)findViewById(R.id.ViewPax);
        seeprice=(TextView)findViewById(R.id.ViewBill);


    Tn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(Tn1.isChecked()){
                Tn1.setEnabled(true);
                seeprice.setText(Double.toString(GSTONLY));
                seepax.setText(Double.toString(payersGST));
            }
            else{
                seeprice.setText(Double.toString(price));
                seepax.setText(Double.toString(mepek));
            }
        }
    });
        Tn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Tn2.isChecked()){
                    Tn1.setEnabled(true);
                    seeprice.setText(Double.toString(SVCONLY));
                    seepax.setText(Double.toString(payersSVC));
                }
                else{
                    seeprice.setText(Double.toString(price));
                    seepax.setText(Double.toString(mepek));
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount.setText("0");
                pax.setText("0");
            }


        });



    }

    public void splitClicked(View view) {
        try {
            price = Integer.valueOf(amount.getText().toString());
            int NoP = Integer.valueOf(pax.getText().toString());
            GSTONLY = price / 100 * 100.7;
            SVCONLY = price / 100 * 100.5;
            payersSVC = SVCONLY / Integer.valueOf(pax.getText().toString());
            payersGST = GSTONLY / Integer.valueOf(pax.getText().toString());
            mepek = price / Integer.valueOf(pax.getText().toString());
            PAYBOTH = (price/100 * 101.3)/Integer.valueOf(pax.getText().toString());

        }catch (Exception ex){
            Log.e("Calculation error: ",ex.getMessage());
    }}
}
