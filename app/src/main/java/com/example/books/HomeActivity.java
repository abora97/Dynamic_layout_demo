package com.example.books;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.imageSlider)
    SliderView imageSlider;
    @BindView(R.id.lay_main)
    LinearLayout layout;
    List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        addDummyData();
        layout.removeAllViews();
        initHeader("main category","bookRecycle");
        initHeader("category","newsRecycler");
        imageSlider.setSliderAdapter(new SliderAdapter(this));
    }

    private void addDummyData() {
        stringList = new ArrayList<>();
        stringList.add("bahbooor");
        stringList.add("abora");
        stringList.add("test");
        stringList.add("lol");
        stringList.add("guran");
        stringList.add("bahbooor");
        stringList.add("abora");
        stringList.add("test");
        stringList.add("lol");
        stringList.add("guran");
    }

    private void initHeader(String header, String type) {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setPadding(16, 8, 16, 8);

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.book);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(45, TableRow.LayoutParams.MATCH_PARENT);
        lp.setMargins(6, 0, 6, 0);
        imageView.setLayoutParams(lp);
        linearLayout.addView(imageView);

        TextView mainCategoryTV = new TextView(this);
        mainCategoryTV.setText(header);
        // mainCategoryTV.setGravity(Gravity.START);
        mainCategoryTV.setTextColor(getResources().getColor(R.color.black));
        mainCategoryTV.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
        linearLayout.addView(mainCategoryTV);

        TextView tvMore = new TextView(this);
        tvMore.setText("more");
        linearLayout.addView(tvMore);
        tvMore.setTextColor(getResources().getColor(R.color.red));
        layout.addView(linearLayout);


        switch (type) {
            case "bookRecycle":
                bookRecycler();
                break;
            case "newsRecycler":
                NewsProduct();
                break;
        }

    }

    private void NewsProduct() {
        ItemCategoryAdapter itemCategoryAdapter = new ItemCategoryAdapter(HomeActivity.this);
        itemCategoryAdapter.addItems(stringList);
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false));
        recyclerView.addItemDecoration(new SpacesItemDecoration(20, 2, true));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(itemCategoryAdapter);
        if (layout != null) layout.addView(recyclerView);
    }

    private void bookRecycler() {
        ItemCategoryAdapter itemCategoryAdapter = new ItemCategoryAdapter(HomeActivity.this);
        itemCategoryAdapter.addItems(stringList);
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1, RecyclerView.HORIZONTAL, false));
        recyclerView.addItemDecoration(new SpacesItemDecoration(20, 0, true));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(itemCategoryAdapter);
        if (layout != null) layout.addView(recyclerView);
    }
}
