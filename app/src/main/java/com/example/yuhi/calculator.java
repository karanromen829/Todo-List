package com.example.yuhi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculator extends AppCompatActivity {

    TextView textViewResult;
    StringBuilder currentNumber = new StringBuilder();
    double operand1 = Double.NaN;
    double operand2;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        textViewResult = findViewById(R.id.textViewResult);

        // Number buttons
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        button0.setOnClickListener(onNumberClickListener);
        button1.setOnClickListener(onNumberClickListener);
        button2.setOnClickListener(onNumberClickListener);
        button3.setOnClickListener(onNumberClickListener);
        button4.setOnClickListener(onNumberClickListener);
        button5.setOnClickListener(onNumberClickListener);
        button6.setOnClickListener(onNumberClickListener);
        button7.setOnClickListener(onNumberClickListener);
        button8.setOnClickListener(onNumberClickListener);
        button9.setOnClickListener(onNumberClickListener);

        // Operation buttons
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);

        buttonPlus.setOnClickListener(onOperationClickListener);
        buttonMinus.setOnClickListener(onOperationClickListener);
        buttonMultiply.setOnClickListener(onOperationClickListener);
        buttonDivide.setOnClickListener(onOperationClickListener);

        // Clear button
        Button buttonCls = findViewById(R.id.buttonCls);
        buttonCls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        // Equal button
        Button buttonEqual = findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation();
            }
        });
    }

    private View.OnClickListener onNumberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            currentNumber.append(button.getText().toString());
            textViewResult.setText(currentNumber.toString());
        }
    };

    private View.OnClickListener onOperationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!Double.isNaN(operand1)) {
                performOperation();
            }
            Button button = (Button) v;
            operand1 = Double.parseDouble(currentNumber.toString());
            operator = button.getText().toString().charAt(0);
            currentNumber.setLength(0);
        }
    };

    private void performOperation() {
        if (!Double.isNaN(operand1) && currentNumber.length() > 0) {
            operand2 = Double.parseDouble(currentNumber.toString());
            switch (operator) {
                case '+':
                    operand1 += operand2;
                    break;
                case '-':
                    operand1 -= operand2;
                    break;
                case '*':
                    operand1 *= operand2;
                    break;
                case '/':
                    if (operand2 != 0) {
                        operand1 /= operand2;
                    } else {
                        clear();
                        textViewResult.setText("Error");
                        return;
                    }
                    break;
            }
            textViewResult.setText(String.valueOf(operand1));
            currentNumber.setLength(0);
            operand2 = Double.NaN;
        }
    }

    private void clear() {
        textViewResult.setText("0");
        currentNumber.setLength(0);
        operand1 = Double.NaN;
        operand2 = Double.NaN;
        operator = '\u0000'; // Null character
    }
}
