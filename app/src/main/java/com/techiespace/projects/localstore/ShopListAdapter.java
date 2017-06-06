package com.techiespace.projects.localstore;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by techiespace on 7/6/17.
 */

public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.ShopListHolder> {

    String data1[];
    String data2[];
    int img[];
    Context ctx;

    public ShopListAdapter(Context ct, String s1[], String s2[], int i1[]) {
        ctx = ct;
        data1 = s1;
        data2 = s2;
        img = i1;
    }

    @Override
    public ShopListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater myInflator = LayoutInflater.from(ctx);
        View myOwnView = myInflator.inflate(R.layout.shop_item, parent, false);    //the 2nd and 3rd args are the view grp and do u want to attach the view grp
        return new ShopListHolder(myOwnView);
    }

    @Override
    public void onBindViewHolder(ShopListHolder holder, int position) {
        holder.item_title.setText(data1[position]);
        holder.item_desc.setText(data2[position]);
        holder.item_img.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class ShopListHolder extends RecyclerView.ViewHolder {
        TextView item_title, item_desc;
        ImageView item_img;

        public ShopListHolder(View itemView) {
            super(itemView);
            item_title = (TextView) itemView.findViewById(R.id.productNameTextView);
            item_desc = (TextView) itemView.findViewById(R.id.productDescTextView);
            item_img = (ImageView) itemView.findViewById(R.id.product_image);
        }
    }
}
