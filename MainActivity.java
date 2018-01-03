package com.example.shesh.calcself;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shesh.calcself.databinding.ActivityMainBinding;

import java.text.DecimalFormat;


public class MainActivity extends Activity {

    private ActivityMainBinding binding;
    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private char CURRENT_ACTION;

    DecimalFormat decimalFormat = new DecimalFormat("#.##########");

    public void actionDigit(View view) {
        Button b = (Button) view;
        binding.inputText.setText(binding.inputText.getText().toString() + b.getText().toString());
    }


    public void actionDot(View view){
        Button b = (Button)view;
        if(b.getText().toString().contains(".")){
            //  Do Nothing
        }
        else{
            binding.inputText.setText(binding.inputText.getText().toString() + b.getText().toString());
        }
    }
    public void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.inputText.getText().toString());
            binding.inputText.setText(null);

            if (CURRENT_ACTION == ADDITION)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUBTRACTION)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MULTIPLICATION)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIVISION)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(binding.inputText.getText().toString());
            } catch (Exception e) {
                //  Do nothing
            }
        }
    }

    public void Add(View view){
        if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() == 0){
            //  Do Nothing
        }
        else if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() != 0){
            //  Do Nothing
        }
        else{
            computeCalculation();
            CURRENT_ACTION = ADDITION;
            binding.outputText.setText(decimalFormat.format(valueOne));
            binding.inputText.setText(null);
        }
    }

    public void Sub(View view){
        if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() == 0){
            //  Do Nothing
        }
        else if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() != 0){
            //  Do Nothing
        }
        else{
            computeCalculation();
            CURRENT_ACTION = SUBTRACTION;
            binding.outputText.setText(decimalFormat.format(valueOne));
            binding.inputText.setText(null);
        }
    }


    public void Mul(View view){
        if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() == 0){
            //  Do Nothing
        }
        else if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() != 0){
            //  Do Nothing
        }
        else{
            computeCalculation();
            CURRENT_ACTION = MULTIPLICATION;
            binding.outputText.setText(decimalFormat.format(valueOne));
            binding.inputText.setText(null);
        }
    }


    public void Div(View view){
        if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() == 0){
            //  Do Nothing
        }
        else if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() != 0){
            //  Do Nothing
        }
        else{
            computeCalculation();
            CURRENT_ACTION = DIVISION;
            binding.outputText.setText(decimalFormat.format(valueOne));
            binding.inputText.setText(null);
        }
    }

    public void Equal(View view){
        if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() == 0){
            //  Do Nothing
        }
        else if(binding.inputText.getText().toString().length() == 0 && binding.outputText.getText().toString().length() != 0){
            binding.outputText.setText(binding.outputText.getText().toString());
        }
        else{
            computeCalculation();
            if(!Double.isNaN(valueOne)){
                binding.outputText.setText(decimalFormat.format(valueOne));
            }
            valueOne = Double.NaN;
            CURRENT_ACTION = '0';
        }

    }

    public void Clear(View view){
        binding.outputText.setText(null);
        binding.inputText.setText(null);
    }

    public void Back(View view){
        String a = binding.inputText.getText().toString();
        int n = a.length();
        if(n>0){
            binding.inputText.setText(a.substring(0,n-1));
        }
    }

    public void Root(View view)
    {
        if(binding.inputText.getText().toString().length() != 0){
            valueOne = Double.parseDouble(binding.inputText.getText().toString());
            valueOne = Math.sqrt(valueOne);
            binding.outputText.setText(decimalFormat.format(valueOne));
        }
    }

    public void CubeRoot(View view)
    {
        if(binding.inputText.getText().toString().length() != 0){
            valueOne = Double.parseDouble(binding.inputText.getText().toString());
            valueOne = Math.cbrt(valueOne);
            binding.outputText.setText(decimalFormat.format(valueOne));
        }
    }

    public void Sin(View view){
        if(binding.inputText.getText().toString().length() != 0){
            valueOne = Double.parseDouble(binding.inputText.getText().toString());
            valueOne = Math.sin(Math.toRadians(valueOne));
            binding.outputText.setText(decimalFormat.format(valueOne));
        }
    }

    public void Cos(View view){
        if(binding.inputText.getText().toString().length() != 0){
            valueOne = Double.parseDouble(binding.inputText.getText().toString());
            valueOne = Math.cos(Math.toRadians(valueOne));
            binding.outputText.setText(decimalFormat.format(valueOne));
        }
    }


    public void Tan(View view){
        if(binding.inputText.getText().toString().length() != 0){
            valueOne = Double.parseDouble(binding.inputText.getText().toString());
            valueOne = Math.tan(Math.toRadians(valueOne));
            binding.outputText.setText(decimalFormat.format(valueOne));
        }
    }

    public void Log(View view){
        if(binding.inputText.getText().toString().length() != 0){
            valueOne = Double.parseDouble(binding.inputText.getText().toString());
            valueOne = Math.log10(valueOne);
            binding.outputText.setText(decimalFormat.format(valueOne));
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
    }
}
