package com.techiespace.projects.localstore;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    public class ShopListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item_title, item_desc;
        ImageView item_img;

        public ShopListHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item_title = (TextView) itemView.findViewById(R.id.productNameTextView);
            item_desc = (TextView) itemView.findViewById(R.id.productDescTextView);
            item_img = (ImageView) itemView.findViewById(R.id.product_image);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(ctx, "this position is " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            Intent product = new Intent(ctx, ProductPage.class);
            product.putExtra(android.content.Intent.EXTRA_TEXT, Integer.toString(getLayoutPosition()));
            ctx.startActivity(product);
        }
    }
}
