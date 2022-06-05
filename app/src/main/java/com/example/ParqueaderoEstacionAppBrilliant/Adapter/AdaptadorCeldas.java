package com.example.ParqueaderoEstacionAppBrilliant.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ParqueaderoEstacionAppBrilliant.Celdas;
import com.example.ParqueaderoEstacionAppBrilliant.R;
import java.util.ArrayList;

public class AdaptadorCeldas extends RecyclerView.Adapter<AdaptadorCeldas.ViewHolderCeldas>{

    ArrayList<Celdas> celdas;

    public AdaptadorCeldas() { }
    public AdaptadorCeldas(ArrayList<Celdas> celdas) {
        this.celdas = celdas;
    }

    @NonNull
    @Override
    public ViewHolderCeldas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_celdas, null, false);
        return new ViewHolderCeldas(view );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCeldas holder, int position) {
        holder.etiCelda.setText(celdas.get(position).getIdCelda().toString());
        holder.etiUbicacion.setText(celdas.get(position).getUbicacion());
    }

    @Override
    public int getItemCount() {  return celdas.size(); }

    public class ViewHolderCeldas extends RecyclerView.ViewHolder {
        TextView etiCelda, etiUbicacion;
        public ViewHolderCeldas(@NonNull View itemView) {
            super(itemView);
            etiCelda= itemView.findViewById(R.id.campoIdCelda);
            etiUbicacion= itemView.findViewById(R.id.campoUbicacionCelda);
        }
    }
}
