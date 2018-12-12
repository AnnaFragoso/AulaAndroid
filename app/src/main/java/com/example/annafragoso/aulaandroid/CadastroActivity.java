package com.example.annafragoso.aulaandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CadastroActivity extends AppCompatActivity {
    EditText txtEmail;
    EditText txtSenha;
    Button btnCad;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);
        btnCad = findViewById(R.id.btnCad);

        final SharedPreferences prefs = getSharedPreferences("usuario", MODE_PRIVATE);

        if(prefs.contains("email")){
            Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
            startActivity(intent);
        }

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


                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", usuario.getEmail());
                editor.apply();



                /*------------------------------------------------ VALIDAÇÃO--------------------------------------------*/
                if (txtEmail.getText().toString().isEmpty()) {
                    boolean emailValido = validate(txtEmail.getText().toString());
                    if(!emailValido) {
                        Snackbar.make(v, "Informar email/senha!", Snackbar.LENGTH_SHORT)
                                .setAction("Ação", null).show();
                    }
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

   public static boolean validate(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
}
