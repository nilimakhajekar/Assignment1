package com.example.calculator;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.calculator.databinding.ActivityMainBinding;
import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;

public class MainActivity extends AppCompatActivity {


   private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';
    private char CURRENT_ACTION;
    ActivityMainBinding binding;
    private double valueOne = Double.NaN;
    private double valueTwo;

    private DecimalFormat decimalFormat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decimalFormat = new DecimalFormat("#.##########");
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "7");
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "8");
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "9");
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "4");
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "5");
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "6");
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "1");
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "2");
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "3");
            }
        });
        binding.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + ".");
            }
        });
        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.edittxt.setText(binding.edittxt.getText() + "0");
            }
        });
        binding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                binding.txt1.setText(binding.txt1.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });


        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADD;
                binding.txt1.setText(decimalFormat.format(valueOne) + "+");
                binding.edittxt.setText(null);
            }
        });

        binding.btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUB;
                binding.txt1.setText(decimalFormat.format(valueOne) + "-");
                binding.edittxt.setText(null);
            }
        });

        binding.btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MUL;
                binding.txt1.setText(decimalFormat.format(valueOne) + "*");
                binding.edittxt.setText(null);
            }
        });

        binding.btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIV;
                binding.txt1.setText(decimalFormat.format(valueOne) + "/");
                binding.edittxt.setText(null);
            }
        });


        binding.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.edittxt.getText().length() > 0) {
                    CharSequence currentText = binding.edittxt.getText();
                    binding.edittxt.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    binding.edittxt.setText("");
                    binding.txt1.setText("");
                }
            }
        });
    }
    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(binding.edittxt.getText().toString());
            binding.edittxt.setText(null);

            if (CURRENT_ACTION == ADD)
                valueOne = this.valueOne + valueTwo;
            else if (CURRENT_ACTION == SUB)
                valueOne = this.valueOne - valueTwo;
            else if (CURRENT_ACTION == MUL)
                valueOne = this.valueOne * valueTwo;
            else if (CURRENT_ACTION == DIV)
                valueOne = this.valueOne / valueTwo;
        } else {
            try {
                valueOne = Double.parseDouble(binding.edittxt.getText().toString());
            } catch (Exception e) {
            }
        }
    }


}


