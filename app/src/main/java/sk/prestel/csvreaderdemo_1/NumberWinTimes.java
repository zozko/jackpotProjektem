package sk.prestel.csvreaderdemo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberWinTimes extends AppCompatActivity implements Serializable {
    private static final String TAG = "NumberWinTimes";
    private ListView numberWins;
    public static int max;   //ehhez a valtozohoz hozzafernek az egesz csomagbol! ! !

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_win_times);
        numberWins = findViewById(R.id.lv_numberWinTimes);  //a megjelenitendo ListView

        List<HetiSzamok> nyertesSzamok = getIntent().getParcelableArrayListExtra("winnerList");
        List<Integer> szamPerDarab = new ArrayList<>();

        Map<Integer, Integer> mindenSzamKihuzvaOsszesen = new HashMap<>();
        if (!nyertesSzamok.isEmpty()) {
            for (int i = 0; i < 50; i++) {
                SzamAdat kihizvaosszesen = new SzamAdat();
                for (HetiSzamok sor : nyertesSzamok) {
                    if (sor.getElso() == i + 1 || sor.getMasodik() == i + 1 || sor.getHarmadik() == i + 1 || sor.getNegyedik() == i + 1 || sor.getOtodik() == i + 1) {
                        kihizvaosszesen.setSzamKihuzvaOsszesen(1);
                    }
                }
                mindenSzamKihuzvaOsszesen.put(i + 1, kihizvaosszesen.getSzamKihuzvaOsszesen());  //ebben a listaban van hogy melyik szam honyszor lett kihuzva...
                szamPerDarab.add(kihizvaosszesen.getSzamKihuzvaOsszesen());   //ebben a listaban van, hogy melyik hanyszor lett kihuzva...

            }
            max = 0;
            int key = 0;
            for (int i = 1; i <= 50; i++) {
                if ((Integer) mindenSzamKihuzvaOsszesen.get(i) > max) {
                    max = (Integer) mindenSzamKihuzvaOsszesen.get(i);
                }
                Log.d(TAG, "onCreate: " + i + " van: " + mindenSzamKihuzvaOsszesen.get(i));
                Log.d(TAG, "onCreate: " + i + " szam :" + szamPerDarab.get(i-1) + "x van kihuzva");
            }


            //megjelenites - adapter
            NumberWinsTimesAdapter adapter = new NumberWinsTimesAdapter(this, R.layout.winxtimes, szamPerDarab);
            numberWins.setAdapter(adapter);


        } else {
            Toast.makeText(this, "first you have to sync numbers!", Toast.LENGTH_LONG).show();
        }

    }
}
