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
    private ViewGroup mensagens;

    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_lista, container, false);

        mensagens = (ViewGroup) v.findViewById(R.id.container);
        //addItem("Título 1", "Exemplo de mensagem.");


        return v;
    }

    private void addItem(String textoDoTitulo, String textoDaMensagem) {
        CardView cardView = (CardView) LayoutInflater.from(getActivity())
                .inflate(R.layout.card, mensagens, false);
        TextView titulo = (TextView) cardView.findViewById(R.id.titulo);
        TextView mensagem = (TextView) cardView.findViewById(R.id.mensagem);
        titulo.setText(textoDoTitulo);
        mensagem.setText(textoDaMensagem);
        mensagens.addView(cardView);
    }



}
