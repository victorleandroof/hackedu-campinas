package br.gov.sp.campinas.model;

import java.io.Serializable;

public enum TipoUsuario implements Serializable {

    PROFESSOR("PROFESSOR"),RESPONSAVEL("RESPONSAVEL");

    public String tipoPerfil;

    TipoUsuario(String tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

}
