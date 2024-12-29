import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MeetingScheduleActivity extends AppCompatActivity {
    private EditText dateInput, timeInput, agendaInput;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_schedule);

        dateInput = findViewById(R.id.dateInput);
        timeInput = findViewById(R.id.timeInput);
        agendaInput = findViewById(R.id.agendaInput);
        Button addButton = findViewById(R.id.addButton);

        DBHelper dbHelper = new DBHelper(this);
        db = dbHelper.getWritableDatabase();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = dateInput.getText().toString();
                String time = timeInput.getText().toString();
                String agenda = agendaInput.getText().toString();

                if (date.isEmpty() || time.isEmpty() || agenda.isEmpty()) {
                    Toast.makeText(MeetingScheduleActivity.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                } else {
                    ContentValues values = new ContentValues();
                    values.put("date", date);
                    values.put("time", time);
                    values.put("agenda", agenda);
                    db.insert("Meetings", null, values);
                    Toast.makeText(MeetingScheduleActivity.this, "Meeting Added!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
