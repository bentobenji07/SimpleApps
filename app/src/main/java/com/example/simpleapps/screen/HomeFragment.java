package com.example.simpleapps.screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.simpleapps.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<ItemModel> arrayList;

    int image[] = {R.drawable.android1, R.drawable.android2,R.drawable.android3};
    CustomAdapter adapter;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        arrayList = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            ItemModel itemModel = new ItemModel();
            itemModel.setImage(image[i]);
            //add in array list
            arrayList.add(itemModel);
        }

        adapter = new CustomAdapter(arrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public class ItemModel {
        int image;
        public int getImage() {
            return image;
        }
        public void setImage(int image) {
            this.image = image;
        }

    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.viewHolder>{

        ArrayList<ItemModel> arrayList;
        public CustomAdapter(ArrayList<ItemModel> arrayList) {
            this.arrayList = arrayList;
        }
        @Override
        public  viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.home_rec_holder, viewGroup, false);
            return new viewHolder(view);
        }
        @Override
        public  void onBindViewHolder(viewHolder viewHolder, final int position) {
            viewHolder.image.setImageResource(arrayList.get(position).getImage());

            viewHolder.image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),DetailActivity.class);
                    intent.putExtra(getResources().getString(R.string.from), position);
                    startActivity(intent);



                }
            });


        }
        @Override
        public int getItemCount() {
            return arrayList.size();
        }
        public class viewHolder extends RecyclerView.ViewHolder {
            ImageView image;
            public viewHolder(final View itemView) {
                super(itemView);
                image = (ImageView) itemView.findViewById(R.id.image);

            }
        }
    }
}
