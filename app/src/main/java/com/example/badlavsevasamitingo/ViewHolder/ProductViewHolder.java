package com.example.badlavsevasamitingo.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.badlavsevasamitingo.Interface.ItemClickListener;
import com.example.badlavsevasamitingo.R;

public  class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txtProductName,txtProductDescription;
    public ImageView imageView;
    public ItemClickListener listner;
    public ProductViewHolder(@NonNull View itemView)
    {
        super(itemView);

        imageView=(ImageView) itemView.findViewById(R.id.product_img);
        txtProductName=(TextView) itemView.findViewById(R.id.product_nm);
        txtProductDescription=(TextView) itemView.findViewById(R.id.product_descrip);

    }
   public void setListner(ItemClickListener listner){
        this.listner=listner;
   }

    @Override
    public void onClick(View v) {
        listner.onClick(v ,getAdapterPosition(),false);
    }
   }


