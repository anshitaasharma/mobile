package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {private EditText editText;
private TextView resultView;
private double valueOne = Double.NaN;
private double valueTwo;
private char CURRENT_ACTION;
private final char ADDITION = '+';
private final char SUBTRACTION = '-';
private final char MULTIPLICATION = '*';
private final char DIVISION = '/';
private final char EQU = '=';
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
editText = findViewById(R.id.edittext);
resultView = findViewById(R.id.textView);
Button button0 = findViewById(R.id.btn0);
Button button1 = findViewById(R.id.btn1);
Button button2 = findViewById(R.id.btn2);
Button button3 = findViewById(R.id.btn3);
Button button4 = findViewById(R.id.btn4);
Button button5 = findViewById(R.id.btn5);
Button button6 = findViewById(R.id.btn6);
Button button7 = findViewById(R.id.btn7);
Button button8 = findViewById(R.id.btn8);
Button button9 = findViewById(R.id.btn9);
Button buttonDot = findViewById(R.id.btndot);
Button buttonAdd = findViewById(R.id.btnplus);
Button buttonSub = findViewById(R.id.btnsub);
Button buttonMul = findViewById(R.id.btnmul);
Button buttonDiv = findViewById(R.id.btndiv);
Button buttonEqual = findViewById(R.id.btnequals);
Button buttonClear = findViewById(R.id.btnc);
View.OnClickListener numberListener = v -> {
Button b = (Button) v;
editText.setText(editText.getText().toString() +
b.getText().toString());
};
button0.setOnClickListener(numberListener);
button1.setOnClickListener(numberListener);
button2.setOnClickListener(numberListener);
button3.setOnClickListener(numberListener);
button4.setOnClickListener(numberListener);
button5.setOnClickListener(numberListener);
button6.setOnClickListener(numberListener);
button7.setOnClickListener(numberListener);
button8.setOnClickListener(numberListener);
button9.setOnClickListener(numberListener);
buttonDot.setOnClickListener(numberListener);
buttonAdd.setOnClickListener(v -> {
performOperation();
CURRENT_ACTION = ADDITION;
resultView.setText(String.valueOf(valueOne) + "+");
editText.setText(null);
});
buttonSub.setOnClickListener(v -> {
performOperation();
CURRENT_ACTION = SUBTRACTION;
resultView.setText(String.valueOf(valueOne) + "-");
editText.setText(null);
});
buttonMul.setOnClickListener(v -> {
performOperation();
CURRENT_ACTION = MULTIPLICATION;
resultView.setText(String.valueOf(valueOne) + "*");
editText.setText(null);
});
buttonDiv.setOnClickListener(v -> {
performOperation();
CURRENT_ACTION = DIVISION;
resultView.setText(String.valueOf(valueOne) + "/");
editText.setText(null);
});
buttonEqual.setOnClickListener(v -> {
performOperation();
CURRENT_ACTION = EQU;
resultView.setText("Result = " + valueOne);
editText.setText(null);
});
buttonClear.setOnClickListener(v -> {
valueOne = Double.NaN;
valueTwo = Double.NaN;
editText.setText("");
resultView.setText("Result = ");
});
}
private void performOperation() {
if (!Double.isNaN(valueOne)) {
valueTwo =
Double.parseDouble(editText.getText().toString());
switch (CURRENT_ACTION) {
case ADDITION:
valueOne = valueOne + valueTwo;
break;
case SUBTRACTION:
valueOne = valueOne - valueTwo;
break;
case MULTIPLICATION:
valueOne = valueOne * valueTwo;
break;
case DIVISION:
valueOne = valueOne / valueTwo;
break;
case EQU:
break;
}
} else {
valueOne =
Double.parseDouble(editText.getText().toString());
}
}
}
