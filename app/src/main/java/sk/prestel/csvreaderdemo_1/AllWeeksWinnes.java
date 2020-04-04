package sk.prestel.csvreaderdemo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AllWeeksWinnes extends AppCompatActivity implements Serializable {
    private static final String TAG = "AllWeeksWinnes";
    private ListView weeklywinners;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_weeks_winnes);
        weeklywinners = findViewById(R.id.lv_weeklyWinners);

        intent = getIntent();

        List<HetiSzamok> winners = getIntent().getParcelableArrayListExtra("winnerList");

        for (Object szamok: winners) {
            Log.d(TAG, "onCreate: A MASIK ACTIVITYBEN...: "+szamok);
        }

        WinnerNumbersAdapter adapter = new WinnerNumbersAdapter(this, R.layout.weekly, winners);
        weeklywinners.setAdapter(adapter);



    }
}
