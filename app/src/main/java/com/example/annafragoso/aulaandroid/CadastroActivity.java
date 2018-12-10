package com.example.annafragoso.aulaandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    EditText txtEmail;
    EditText txtSenha;
    Button btnCad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        btnCad = findViewById(R.id.btnCad);

        Usuario usuario = UsuarioSingleton.getInstance().getUsuario();

        if(usuario != null) {
            txtEmail.setText(usuario.getEmail());
        }
        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                usuario.setEmail(txtEmail.getText().toString());
                usuario.setSenha(txtSenha.getText().toString());

                UsuarioSingleton.getInstance().setUsuario(usuario);

                SharedPreferences prefs = getSharedPreferences("usuario", MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("email", usuario.getEmail());

                editor.apply();

                /*------------------------------------------------ VALIDAÇÃO--------------------------------------------*/
                if (txtEmail.getText().toString().isEmpty()) {
                    Snackbar.make(v, "Informar email/senha!", Snackbar.LENGTH_SHORT)
                            .setAction("Ação", null).show();
                    return;
                }

                if (txtSenha.getText().toString().isEmpty()) {
                    Snackbar.make(v, "Informar email/senha!", Snackbar.LENGTH_SHORT)
                            .setAction("Ação", null).show();
                    return;
                } else {

                    if (txtEmail.getText().toString() != null) {
                        Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    if (txtSenha.getText().toString() != null) {
                        Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        };
        btnCad.setOnClickListener(listener);

    }
}
