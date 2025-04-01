import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Usuario {
    String nome;
    String senha;
    String email;
    
    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }
    
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}