package com.example.halkhomeworkatakan.MyAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.halkhomeworkatakan.ItemDetailActivity;
import com.example.halkhomeworkatakan.Model.RowModel;
import com.example.halkhomeworkatakan.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {

    Context context;
    List<RowModel> modelList;

    public Adapter(Context context, List<RowModel> modelList) {
        this.context = context;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String name = modelList.get(position).getName();
        String messages = modelList.get(position).getMessage();
        int image = modelList.get(position).getImage();

        holder.name.setText(name);
        holder.message.setText(messages);
        holder.imageView.setImageResource(R.drawable.ic_launcher_background);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView name, message;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.itemImage);
            name = itemView.findViewById(R.id.nameTxt);
            message = itemView.findViewById(R.id.messageTxt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            //Toast.makeText(context, "position" + position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, ItemDetailActivity.class);
            intent.putExtra("name", modelList.get(position).getName());
            intent.putExtra("message", modelList.get(position).getMessage());
            //intent.putExtra("image",modelList.get(position).getImage());

            context.startActivity(intent);
        }
    }
}
