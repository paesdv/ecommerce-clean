package com.ecommerce.clean.usuario.domain;

import java.util.UUID;
import java.util.regex.Pattern;

public class Usuario {

    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private Role role;

    public Usuario(UUID id, String nome, String email, String senha){
        if(nome == null || nome.isBlank()){
            throw new UsuarioInvalidoException("Nome do usuario nao pode ser vazio");
        }
        if(email == null || email.isBlank()){
            throw new UsuarioInvalidoException("Email do usuario nao pode ser vazio");
        }
        if(senha == null || senha.isBlank()){
            throw new UsuarioInvalidoException("Senha nao pode ser vazia");
        }
        if(!EMAIL_REGEX.matcher(email).matches()){
            throw new UsuarioInvalidoException("Email invalido");
        }
        if(senha.length() < 8){
            throw new UsuarioInvalidoException("Senha deve ter no minimo 8 caracteres");
        }

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role.USER;
    }

    public void promoverParaAdmin(){
        if(this.role == Role.ADMIN){
            throw new UsuarioInvalidoException("Usuario ja e admin");
        }
        this.role = Role.ADMIN;
    }

    public void rebaixarParaUsuario(){
        if(this.role == Role.USER){
            throw new UsuarioInvalidoException("Usuario ja e um usuario comum");
        }
        this.role = Role.USER;
    }

    public void alterarEmail(String senhaAtual, String novoEmail){
    if(!this.senha.equals(senhaAtual)){
        throw new SenhaInvalidaException("Senha atual incorreta");
    }
    if(novoEmail == null || novoEmail.isBlank()){
        throw new UsuarioInvalidoException("Novo email nao pode ser vazio");
    }
    if(!EMAIL_REGEX.matcher(novoEmail).matches()){
        throw new UsuarioInvalidoException("Email invalido");
    }
    if(novoEmail.equals(this.email)){
        throw new UsuarioInvalidoException("Novo email deve ser diferente do atual");
    }
    this.email = novoEmail;
}

    public void alterarSenha(String senhaAtual, String novaSenha){
        if(!this.senha.equals(senhaAtual)){
            throw new SenhaInvalidaException("Senha atual incorreta");
        }
        if(novaSenha == null || novaSenha.isBlank()){
            throw new UsuarioInvalidoException("Nova senha nao pode ser vazia");
        }
        if(novaSenha.length() < 8){
            throw new UsuarioInvalidoException("Senha deve ter no minimo 8 caracteres");
        }
        if(novaSenha.equals(senhaAtual)){
            throw new UsuarioInvalidoException("Nova senha deve ser diferente da atual");
        }
        this.senha = novaSenha;
    }

    private static final Pattern EMAIL_REGEX =
            Pattern.compile("^[\\w.+-]+@[\\w-]+\\.[a-zA-Z]{2,}$");


    public UUID getId(){
        return id;
    }

    public void setId(UUID id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public Role getRole(){
        return role;
    }

    private Usuario(){}

public static Usuario reconstituir(UUID id, String nome, String email, String senha, Role role){
    Usuario usuario = new Usuario();
    usuario.id = id;
    usuario.nome = nome;
    usuario.email = email;
    usuario.senha = senha;
    usuario.role = role;
    return usuario;
}

}
