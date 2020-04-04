package sk.prestel.csvreaderdemo_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class WinnerNumbersAdapter extends ArrayAdapter<HetiSzamok> {
    private Context context;
    private int myResource;

    public WinnerNumbersAdapter(@NonNull Context context, int resource, @NonNull List<HetiSzamok> objects) {
        super(context, resource, objects);
        this.context = context;
        this.myResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        int weekPosition = position + 1;
        HetiSzamok hSzamok = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(myResource, null);
        }

        TextView weekNo = convertView.findViewById(R.id.tv_weekNumber);

        TextView noOne = convertView.findViewById(R.id.tv_elsoSzam);
        TextView noTwo = convertView.findViewById(R.id.tv_masodikSzam);
        TextView noThree = convertView.findViewById(R.id.tv_harmadikSzam);
        TextView noFour = convertView.findViewById(R.id.tv_negyedikSzam);
        TextView noFive = convertView.findViewById(R.id.tv_otodikSzam);

        TextView noOnePlus = convertView.findViewById(R.id.tv_elsoPotSzam);
        TextView noTwoPlus = convertView.findViewById(R.id.tv_masodikPotSzam);


        weekNo.setText(weekPosition + ":");
        noOne.setText(hSzamok.getElso() + "");
        noTwo.setText(hSzamok.getMasodik() + "");
        noThree.setText(hSzamok.getHarmadik() + "");
        noFour.setText(hSzamok.getNegyedik() + "");
        noFive.setText(hSzamok.getOtodik() + "");

        noOnePlus.setText(hSzamok.getElsoPot() + "");
        noTwoPlus.setText(hSzamok.getMasodikPot() + "");


        return convertView;
    }
}
