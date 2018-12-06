package com.example.annafragoso.aulaandroid;

public class UsuarioSingleton {
    private static final UsuarioSingleton
        INSTANCE = new UsuarioSingleton();

    private Usuario usuario;

    private UsuarioSingleton() {

    }

    public static UsuarioSingleton getInstance() {
        return INSTANCE;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
