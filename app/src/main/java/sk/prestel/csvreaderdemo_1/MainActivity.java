package sk.prestel.csvreaderdemo_1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    // private final String filePath = "szamok.csv";
    private Button beolvas;
    private List<HetiSzamok> nyertesSzamok = new ArrayList<>();

    File myExternalFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath() + File.separator + "data.csv");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beolvas = (Button) findViewById(R.id.btn_openFile);

    }


    public void openFile(View view) {


        try {
            InputStream fileInput = new FileInputStream(myExternalFile);
            Log.d(TAG, "openFile: " + fileInput.toString());
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(fileInput, Charset.forName("UTF-8"))
            );

            String line;

            while ((line = reader.readLine()) != null) {
                HetiSzamok hetenteKihuzva = new HetiSzamok();

                String[] szamokTombje = line.split(",");

                hetenteKihuzva.setElso(Integer.parseInt(szamokTombje[0]));
                hetenteKihuzva.setMasodik(Integer.parseInt(szamokTombje[1]));
                hetenteKihuzva.setHarmadik(Integer.parseInt(szamokTombje[2]));
                hetenteKihuzva.setNegyedik(Integer.parseInt(szamokTombje[3]));
                hetenteKihuzva.setOtodik(Integer.parseInt(szamokTombje[4]));
                hetenteKihuzva.setElsoPot(Integer.parseInt(szamokTombje[5]));
                hetenteKihuzva.setMasodikPot(Integer.parseInt(szamokTombje[6]));


                nyertesSzamok.add(hetenteKihuzva);
                //Log.d(TAG, "Listaba: " + hetenteKihuzva.toString());
            }
            reader.close();
            Toast.makeText(this, "numbers are synced...", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.e(TAG, "openFile: HIBA", e);
            Toast.makeText(this, "please, enable storage permission!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.w(TAG, "openFile: " + "hiba a file beolvasasanal", e);
            e.printStackTrace();
        }
    }

    public void allWeeakList(View view) {

        if (!nyertesSzamok.isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), AllWeeksWinnes.class);
            intent.putParcelableArrayListExtra("winnerList", (ArrayList<? extends Parcelable>) nyertesSzamok);
            startActivity(intent);
        } else {
            Toast.makeText(this, "first you have to sync numbers!", Toast.LENGTH_LONG).show();
        }


    }

    public void frequentNumbers(View view) {
        if (!nyertesSzamok.isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), NumberWinTimes.class);
            intent.putParcelableArrayListExtra("winnerList", (ArrayList<? extends Parcelable>) nyertesSzamok);
            startActivity(intent);

        } else {
            Toast.makeText(this, "first you have to sync numbers!", Toast.LENGTH_LONG).show();
        }

    }


}
