package com.example.counter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity
implements View.OnClickListener {
Button start, stop;
TextView ctr;
int counter = 0;
boolean running = false;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
start = findViewById(R.id.btn_start);
stop = findViewById(R.id.btn_stop);
ctr = findViewById(R.id.counter);
start.setOnClickListener(this);
stop.setOnClickListener(this);
}
@Override
public void onClick(View v) {
if (v.equals(start)) {
counter = 0;
running = true;
new MyCounter().start();
} else if (v.equals(stop)) {
running = false;
}
}
Handler handler = new Handler() {
@Override
public void handleMessage(Message m) {
ctr.setText(String.valueOf(m.what));
}
};
class MyCounter extends Thread {
public void run() {
while (running) {
counter++;
handler.sendEmptyMessage(counter);
try {
Thread.sleep(1000);
} catch (Exception e) {
e.printStackTrace();
}
}
}
}
}
