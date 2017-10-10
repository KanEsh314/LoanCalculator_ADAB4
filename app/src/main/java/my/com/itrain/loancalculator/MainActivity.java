package my.com.itrain.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    EditText editText2;
    EditText editText3;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    SeekBar seekbar;
    Button button;

    double propertyprice;
    double downpayment;
    double annualInterest;
    double month;
    double amount;
    double discount;
    double operation;
    EditText editText4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        textView1 = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.loanValue);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                propertyprice = Double.parseDouble(editText.getText().toString());
                downpayment = Double.parseDouble(editText2.getText().toString());
                amount = propertyprice - downpayment;
                double percentage  = Double.parseDouble(editText4.getText().toString());
                annualInterest =( percentage/100) / 12;
                double year = Double.parseDouble(editText3.getText().toString());
                operation = Math.pow(1 + annualInterest,(year*12) );
                discount= (operation -1)/(annualInterest * operation);
                double monthlyPayment = amount/discount;
                textView2.setText("RM "+monthlyPayment);




            }
        });


    }
}
