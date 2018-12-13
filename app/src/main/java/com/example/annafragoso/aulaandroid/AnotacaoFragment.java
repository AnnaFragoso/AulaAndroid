package com.example.annafragoso.aulaandroid;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


public class AnotacaoFragment extends Fragment {
    private EditText txtTitulo;
    private EditText txtDescricao;
    private Button btnSalvarNota;

    private TextView teste;

    public AnotacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_anotacao, container, false);

        txtTitulo = v.findViewById(R.id.txtTitulo);
        txtDescricao = v.findViewById(R.id.txtDescricao);
        btnSalvarNota = v.findViewById(R.id.btnSalvarNota);
        teste = v.findViewById(R.id.teste);

        Nota nota = NotaSingleton.getInstance().getNota();


        View.OnClickListener listenerNota = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nota nota = new Nota();
                nota.setTitulo(txtTitulo.getText().toString());
                nota.setDescricao(txtDescricao.getText().toString());

                NotaSingleton.getInstance().setNota(nota);

                /*Nota note = NotaSingleton.getInstance().getNota();
                teste.setText(note.getTitulo());*/

                Snackbar.make(v, "Anotação salva!", Snackbar.LENGTH_SHORT)
                        .setAction("Ação", null).show();


                MainActivity main = (MainActivity) getActivity();
                main.retornar();




            }
        };
        btnSalvarNota.setOnClickListener(listenerNota);

    return v;
    }


}
