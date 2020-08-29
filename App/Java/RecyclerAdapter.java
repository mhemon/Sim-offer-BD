package com.xploreict.simofferbd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerviewHolder> {
    int lastPosition = 0;
    private String[] data;
    private String[] details;

    public RecyclerAdapter(String[] data, String[] details) {
        this.data = data;
        this.details = details;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.message, viewGroup, false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerviewHolder recyclerviewHolder, @SuppressLint("RecyclerView") int position) {
        final String title = data[position];
        final String message = details[position];
        recyclerviewHolder.txttitle.setText(title);
        recyclerviewHolder.txttitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent intent = new Intent(context, MessageDetails.class);
                intent.putExtra("mesdtls", message);
                intent.putExtra("title", title);
                context.startActivity(intent);

                //check first time
                // if first time then show the toast
                //  Initialize SharedPreferences
                SharedPreferences getPrefses = PreferenceManager
                        .getDefaultSharedPreferences(context);

                //  Create a new boolean and preference and set it to true
                boolean isFirstStartcheck = getPrefses.getBoolean("firstStartcheck", true);

                //  If the activity has never started before...
                if (isFirstStartcheck) {

                    //  Show The Info toast
                    Toasty.info(context, "You Can Adjust Text Size in Setting.", Toast.LENGTH_LONG, true).show();
                    //  Make a new preferences editor
                    SharedPreferences.Editor e = getPrefses.edit();

                    //  Edit preference to make it false because we don't want this to run again
                    e.putBoolean("firstStartcheck", false);

                    //  Apply changes
                    e.apply();
                }
            }
        });
        if (position > lastPosition) {
            AnimationUtil.animate(recyclerviewHolder, true);
        } else {
            AnimationUtil.animate(recyclerviewHolder, false);
        }
        lastPosition = position;
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerviewHolder extends RecyclerView.ViewHolder {
        TextView txttitle;

        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);
            txttitle = (TextView) itemView.findViewById(R.id.statusTextView);
        }
    }
}
