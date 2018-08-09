package com.isi.geison.proyectobasedatos.Adaptador;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.isi.geison.proyectobasedatos.Modelo.Flores;
import com.isi.geison.proyectobasedatos.R;

import java.util.List;

public class FloresRecyclerViewAdapter2 extends RecyclerView.Adapter<FloresRecyclerViewAdapter2.ViewHolder>{

    Context context;
    List<Flores> listaFlores;

    public FloresRecyclerViewAdapter2(Context context, List<Flores> flores) {
        this.context = context;
        this.listaFlores = flores;
    }

    private Context getContext(){
        return context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flores, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvNombre.setText(listaFlores.get(position).getNombre());
        holder.tvPrecio.setText(listaFlores.get(position).getPrecio());

    }

    @Override
    public int getItemCount() {
        return listaFlores.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivProducto;
        private TextView tvNombre, tvPrecio;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
        }
    }
}
