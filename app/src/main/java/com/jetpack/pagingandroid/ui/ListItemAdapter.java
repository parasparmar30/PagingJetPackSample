package com.jetpack.pagingandroid.ui;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jetpack.pagingandroid.R;
import com.jetpack.pagingandroid.wrapper.ItemsDataResponse;

public class ListItemAdapter extends PagedListAdapter<ItemsDataResponse, ListItemAdapter.ItemViewHolder> {

    private Context context;

    ListItemAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemsDataResponse itemsDataResponse = getItem(position);

        if (itemsDataResponse != null) {
            holder.textView.setText(itemsDataResponse.getOwner().getDisplayName());
            Glide.with(context)
                    .load(itemsDataResponse.getOwner().getProfileImage())
                    .into(holder.imageView);
        }
    }

    private static DiffUtil.ItemCallback<ItemsDataResponse> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ItemsDataResponse>() {
                @Override
                public boolean areItemsTheSame(ItemsDataResponse oldItem, ItemsDataResponse newItem) {
                    return oldItem.getAnswerId() == newItem.getAnswerId();
                }

                @Override
                public boolean areContentsTheSame(ItemsDataResponse oldItem, ItemsDataResponse newItem) {
                    return oldItem.equals(newItem);
                }
            };

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txtVwName);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}