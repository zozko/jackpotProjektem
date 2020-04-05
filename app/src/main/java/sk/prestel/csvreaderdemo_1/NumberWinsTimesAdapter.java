package sk.prestel.csvreaderdemo_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Map;

public class NumberWinsTimesAdapter extends ArrayAdapter<Integer> {
    private Context context;
    private int myResource;


    public NumberWinsTimesAdapter(@NonNull Context context, int resource, @NonNull List<Integer> objects) {
        super(context, resource, objects);
        this.context = context;
        this.myResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int numberIndex = position+1;
        Integer kihuzva = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(myResource, null);
        }

        TextView number = convertView.findViewById(R.id.tv_xTimeSzam);
        SeekBar mutato = convertView.findViewById(R.id.sb_display);
        TextView barHint = convertView.findViewById(R.id.tv_seekBarHint);
        mutato.setMax(NumberWinTimes.max);



        //kiiratas:
        number.setText(numberIndex+"");
        mutato.setProgress(kihuzva);
        barHint.setText(kihuzva+"/"+NumberWinTimes.max);

        return convertView;
    }
}
