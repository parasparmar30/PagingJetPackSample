package com.jetpack.pagingandroid.ui;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jetpack.pagingandroid.R;
import com.jetpack.pagingandroid.viewmodel.ItemViewModel;
import com.jetpack.pagingandroid.wrapper.ItemsDataResponse;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        final ListItemAdapter adapter = new ListItemAdapter(this);

        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<ItemsDataResponse>>() {
            @Override
            public void onChanged(@Nullable PagedList<ItemsDataResponse> items) {
                adapter.submitList(items);
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
