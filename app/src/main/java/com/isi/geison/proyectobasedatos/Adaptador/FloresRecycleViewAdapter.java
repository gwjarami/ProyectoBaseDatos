package com.isi.geison.proyectobasedatos.Adaptador;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.isi.geison.proyectobasedatos.Modelo.Flores;
import com.isi.geison.proyectobasedatos.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FloresRecycleViewAdapter extends RecyclerView.Adapter<FloresRecycleViewAdapter.ViewHolder>{

    Context context;
    List<Flores> listaFlores;

    public FloresRecycleViewAdapter(Context context, List<Flores> flores) {
        this.context = context;
        this.listaFlores = flores;
    }

    private Context getContext(){
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flores, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Flores flor = listaFlores.get(position);

        holder.tvNombre.setText(flor.getNombre());
        holder.tvPrecio.setText(flor.getPrecio());


        //para cargar la imagen del stotage
//        Picasso.with(getContext())
//                .load(flor.getPosterPath())
//                .into(holder.ivFlorImage);

    }

    @Override
    public int getItemCount() {
        return listaFlores.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivFlor)
        ImageView ivFlorImage;
        @BindView(R.id.tvNombre)
        TextView tvNombre;
        @BindView(R.id.tvPrecio)
        TextView tvPrecio;
        @BindView(R.id.tvCarrito)
        TextView tvCarrito;
        @BindView(R.id.cvFlores)
        CardView cvFlores;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            tvNombre = (TextView) view.findViewById(R.id.tvNombre);
            tvPrecio = (TextView) view.findViewById(R.id.tvPrecio);
            cvFlores = (CardView) view.findViewById(R.id.cvFlores);

            //view.setOnClickListener(this);

        }

//        @Override
//        public void onClick(View v) {
//
//            Movie movie = movies.get(getAdapterPosition());
//
//            Intent intent = new Intent(getContext(), MovieDetailActivity.class);
//            intent.putExtra("MOVIE", movie);
//            getContext().startActivity(intent);
//
//        }
    }


}
