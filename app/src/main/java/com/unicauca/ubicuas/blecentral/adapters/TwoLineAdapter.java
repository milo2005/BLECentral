package com.unicauca.ubicuas.blecentral.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.unicauca.ubicuas.blecentral.R;

import java.util.List;

/**
 * Created by Dario Chamorro on 23/09/2015.
 */
public class TwoLineAdapter extends BaseAdapter {

    Context context;
    List<TwoLine> data;

    public TwoLineAdapter(Context context, List<TwoLine> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;

        if(convertView == null)
            v =  View.inflate(context, R.layout.template_two_lines, null);
        else
            v = convertView;

        TwoLine twoLine = (TwoLine) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.title);
        txt.setText(twoLine.getTitle());

        txt = (TextView) v.findViewById(R.id.subtitle);
        txt.setText(twoLine.getSubtitle());

        return v;
    }

    //region TwoLine Class
    public class TwoLine{

        public static final int TYPE_DEVICE=0;
        public static final int TYPE_SERVICE=1;
        public static final int TYPE_CHARACTERISTIC=2;

        String title, subtitle;
        int type;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }
    }
    //endregion
}
