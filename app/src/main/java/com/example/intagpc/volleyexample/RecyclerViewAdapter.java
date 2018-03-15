package com.example.intagpc.volleyexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

/**
 * Created by intag pc on 3/14/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.AdapterViewHolder> {

    private Context context;
    private UserGsonModel[] userGsonModel;
    private UserGsonModel users;

    public RecyclerViewAdapter(Context context, UserGsonModel[] userGsonModels) {

        this.context = context;
        this.userGsonModel = userGsonModels;
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new RecyclerViewAdapter.AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {

         users = userGsonModel[position];
        holder.tvUserName.setText(users.getLogin());
        Glide.with(holder.ivUser.getContext()).load(users.getAvatarUrl()).into(holder.ivUser);
    }

    @Override
    public int getItemCount() {
        return userGsonModel.length;
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {

        ImageView ivUser;
        TextView tvUserName;

        public AdapterViewHolder(final View itemView) {
            super(itemView);
            ivUser = (ImageView) itemView.findViewById(R.id.ivUser);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "name = "+itemView.getTag(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }
}
