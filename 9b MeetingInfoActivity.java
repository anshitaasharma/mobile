import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MeetingInfoActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_info);

        datePicker = findViewById(R.id.datePicker);
        Button searchButton = findViewById(R.id.searchButton);

        DBHelper dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
                Cursor cursor = db.rawQuery("SELECT agenda FROM Meetings WHERE date = ?", new String[]{date});

                if (cursor.moveToFirst()) {
                    String agenda = cursor.getString(0);
                    Toast.makeText(MeetingInfoActivity.this, "Agenda: " + agenda, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MeetingInfoActivity.this, "No Meeting on this Date", Toast.LENGTH_SHORT).show();
                }
                cursor.close();
            }
        });
    }
}
