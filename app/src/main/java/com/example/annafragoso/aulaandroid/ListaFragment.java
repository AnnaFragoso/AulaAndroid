package com.example.annafragoso.aulaandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {
    private ViewGroup container;

    public ListaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        container = (ViewGroup) v.findViewById(R.id.container);


        /*teste.setText(note.getTitulo());*/

        /*addItem("oi", "tudo bem");

        /*private void addItem(String textoTitulo, String textoMensagem) {*/


            CardView cardView = (CardView) LayoutInflater.from(getActivity())
                    .inflate(R.layout.card, container, false);
            cardView.findViewById(R.id.titulo);
            TextView titulo = (TextView) cardView.findViewById(R.id.titulo);
            TextView mensagem = (TextView) cardView.findViewById(R.id.mensagem);
            titulo.setText("oi");
            mensagem.setText("td bmm");
            container.addView(cardView);
        /*}*/

        return v;
    }
   /* Nota note = NotaSingleton.getInstance().getNota();
    String textoTitulo = note.getTitulo();
    String textoDescricao = note.getDescricao();*/

    /*private void addItem(String textoTitulo, String textoMensagem) {


       CardView cardView = (CardView) LayoutInflater.from(getActivity())
                .inflate(R.layout.card, container, false);
       cardView.findViewById(R.id.titulo);
        TextView titulo = (TextView) cardView.findViewById(R.id.titulo);
        TextView mensagem = (TextView) cardView.findViewById(R.id.mensagem);
        titulo.setText(textoTitulo);
        mensagem.setText(textoMensagem);
        container.addView(cardView);
    }*/



}
