package com.techiespace.projects.localstore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Shop extends Fragment {


    RecyclerView shopList;
    String itemTitle[], itemDescription[];
    int productImage[] = {R.drawable.dummy_img_1, R.drawable.dummy_img_2, R.drawable.dummy_img_1, R.drawable.dummy_img_2, R.drawable.dummy_img_1, R.drawable.dummy_img_2, R.drawable.dummy_img_1, R.drawable.dummy_img_2};
    ShopListAdapter myshopListAdapter;

    public Shop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_shop, container, false);
        shopList = (RecyclerView) rootView.findViewById(R.id.shopRecyclerView);
        itemTitle = getResources().getStringArray(R.array.item_name);
        itemDescription = getResources().getStringArray(R.array.item_desc);
        myshopListAdapter = new ShopListAdapter(getContext(), itemTitle, itemDescription, productImage);

        shopList.setAdapter(myshopListAdapter);
        shopList.setLayoutManager(new LinearLayoutManager(getContext()));
        return rootView;
    }

}
