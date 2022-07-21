package sg.edu.rp.c346.id21016412.ndpsongs;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Song> versionList;

    public CustomAdapter(Context context, int resource,ArrayList<Song> objects) {
        super(context,resource,objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvName = rowView.findViewById(R.id.tvTitle);
        TextView tvYear= rowView.findViewById(R.id.tvYear);
        TextView tvStar = rowView.findViewById(R.id.tvStars);
        TextView tvSinger = rowView.findViewById(R.id.tvArtist);

        Song currentVersion = versionList.get(position);

        tvName.setText(currentVersion.getTitle());
        tvName.setTextColor(Color.BLUE);
        tvYear.setText(currentVersion.getYear());
        tvStar.setText(currentVersion.toString());
        tvStar.setTextColor( Color.RED);
        tvSinger.setText(currentVersion.getSingers());
        tvSinger.setTextColor(Color.CYAN);

        return rowView;
    }
}