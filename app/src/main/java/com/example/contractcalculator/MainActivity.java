package com.example.contractcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText input_1,input_2;
    Button calculate;
    TextView subtotal,tax,total;
    private static final int rate=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_1=findViewById(R.id.input_1);
        input_2=findViewById(R.id.input_2);
        calculate=findViewById(R.id.calculate);
        subtotal= findViewById(R.id.sub_total);
        tax=findViewById(R.id.tax);
        total=findViewById(R.id.total);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(input_1.getText().toString().length()==0||input_2.getText().toString().length()==0){
                    Toast.makeText(MainActivity.this,"Please Enter Value On Both Fields",Toast.LENGTH_LONG).show();
                    return;
                }
                double labor=Double.parseDouble(input_1.getText().toString());
                double material=Double.parseDouble(input_2.getText().toString());
                double Total=labor+material;
                subtotal.setText("SubTotal : "+Double.toString(Total));
                double Tax=(Total*rate)/100;
                tax.setText("Tax : "+Double.toString(Tax));

                total.setText("Total : "+Double.toString(Total+Tax));


            }
        });

    }
}