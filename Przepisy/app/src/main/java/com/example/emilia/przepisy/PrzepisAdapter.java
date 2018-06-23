package com.example.emilia.przepisy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class PrzepisAdapter extends ArrayAdapter<Przepis>{

    private Context mContext;
    int mLayoutResourceId;
    Przepis mData[] = null;

    public PrzepisAdapter(Context context, int resource, Przepis[] mData) {
        super(context, resource, mData);
        this.mContext = context;
        this.mLayoutResourceId = resource;
        this.mData = mData;
    }

    @Override
    public Przepis getItem(int position){
        return super.getItem(position);
    }


    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        PlaceHolder holder = null;

        //if we currently don't have a row View to reuse..
        if(row == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.from(mContext).inflate(R.layout.row, parent, false);

            holder = new PlaceHolder();

            holder.nameView = (TextView) row.findViewById(R.id.nameTextView);
            holder.zipView = (TextView) row.findViewById(R.id.zipcodeTextView);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);

            row.setTag(holder);
        }else{
            holder = (PlaceHolder) row.getTag();
        }

        Przepis przepis = mData[position];

        holder.imageView.setOnClickListener(PopupListener);
        Integer rowPosition = position;
        holder.imageView.setTag(rowPosition);

        holder.nameView.setText(przepis.title);
        holder.zipView.setText(przepis.description);

        int resId = mContext.getResources().getIdentifier(przepis.nameOfImage, "drawable",mContext.getPackageName());
        holder.imageView.setImageResource(resId);

        return row;

    }

    View.OnClickListener PopupListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer viewPosition = (Integer) view.getTag();
            Przepis p = mData[viewPosition];
            Toast.makeText(getContext(), p.title, Toast.LENGTH_SHORT).show();
        }
    };

    private static class PlaceHolder {
        TextView nameView;
        TextView zipView;
        ImageView imageView;
    }
}
