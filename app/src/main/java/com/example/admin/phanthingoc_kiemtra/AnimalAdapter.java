package com.example.admin.phanthingoc_kiemtra;

import android.app.Dialog;
import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by admin on 6/29/2017.
 */

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Animal> animals;
    private LayoutInflater inflater;
    private TextToSpeech textToSpeech;

    public AnimalAdapter(Context context, ArrayList<Animal> animals) {
        this.context = context;
        this.animals = animals;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_animal, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Dialog dialog=new Dialog(context);
        final Animal animal = animals.get(position);
        holder.imgAnimal.setImageResource(animal.getIdImage());
        holder.txtText.setText(animal.getText());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.setContentView(R.layout.item_dialog);
                ImageView image=dialog.findViewById(R.id.animal);
                image.setImageResource(animal.getIdImage());
                TextView textV=dialog.findViewById(R.id.tvVi);
                textV.setText(animal.getText());
                Toast.makeText(context, animal.getTxtText(), Toast.LENGTH_SHORT).show();
                dialog.show();

                image.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final String name=animal.getTxtText();
                        textToSpeech=new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                            @Override
                            public void onInit(int i) {
                                if (i!=TextToSpeech.ERROR) {
                                    textToSpeech.setLanguage(Locale.ENGLISH);
                                    textToSpeech.speak(name, TextToSpeech.QUEUE_FLUSH, null);
                                }
                            }
                        });
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAnimal;
        TextView txtText;

        public ViewHolder(View itemView) {
            super(itemView);
             imgAnimal= (ImageView) itemView.findViewById(R.id.id_animal);
            txtText = (TextView) itemView.findViewById(R.id.tvVitri);
        }


    }

}
