package com.example.ex1_td1;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListAdapter.SchoolViewHolder>  {
    LinkedList<School> mSchoolList;
    private LayoutInflater mInflater;


    public SchoolListAdapter(Context context,
                             LinkedList<School> schoolList) {
        mInflater = LayoutInflater.from(context);
        this.mSchoolList = schoolList;





    }



    @NonNull
    @Override
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View mItemView = mInflater.inflate(R.layout.school_item,
                parent, false);



        return new SchoolViewHolder(mItemView, this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull SchoolViewHolder holder, int position) {
        School mCurrent = mSchoolList.get(position);
        holder.schoolTitle.setText(mCurrent.getName());
        holder.schoolDescription.setText(mCurrent.getDescription());


        Uri path = Uri.parse("android.resource://com.example.school_list/" + R.drawable.download);
        String imgPath = path.toString();

        holder.schoolImage.setImageURI(path);




    }

    @Override
    public int getItemCount() {
        return mSchoolList.size();
    }

    static class SchoolViewHolder extends RecyclerView.ViewHolder {
        final SchoolListAdapter mAdapter;
        private final TextView schoolTitle;
        private final TextView schoolDescription;
        private final ImageView schoolImage;


        SchoolViewHolder(View schoolItemView, SchoolListAdapter mAdapter) {
            super(schoolItemView);
            this.schoolTitle = schoolItemView.findViewById(R.id.school_title);
            this.schoolDescription = schoolItemView.findViewById(R.id.school_description);
            this.schoolImage = schoolItemView.findViewById(R.id.school_image);



            this.mAdapter = mAdapter;
        }




    }
}