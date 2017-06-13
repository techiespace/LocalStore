package com.techiespace.projects.localstore;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ProductPage extends AppCompatActivity {

    TextView productTitle;
    TextView productDesc;
    String itemTitle[], itemDescription[];
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        Intent intent = getIntent();
        index = Integer.parseInt(intent.getStringExtra(android.content.Intent.EXTRA_TEXT));
        productTitle = (TextView) findViewById(R.id.productTitle);
        productDesc = (TextView) findViewById(R.id.productDisc);
        itemTitle = getResources().getStringArray(R.array.item_name);
        itemDescription = getResources().getStringArray(R.array.item_desc);
        productTitle.setText(itemTitle[index]);
        productDesc.setText(itemDescription[index]);
    }

    public void contact(View view) {
        PackageManager pm = getPackageManager();
        try {
            Uri uri = Uri.parse("smsto:" + "918421946701");
            Intent waIntent = new Intent(Intent.ACTION_SENDTO, uri);
            //waIntent.setType("text/plain");
            //String text = "I want to place a order for "+ itemTitle[index]+". Kindly contact me.";

            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            //waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, ""));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
