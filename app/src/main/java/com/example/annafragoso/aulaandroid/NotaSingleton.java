package com.example.annafragoso.aulaandroid;

public class NotaSingleton {

    private static final NotaSingleton
            INSTANCE = new NotaSingleton();

    private Nota nota;

    private NotaSingleton() {

    }

    public static NotaSingleton getInstance() {
        return INSTANCE;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
}
