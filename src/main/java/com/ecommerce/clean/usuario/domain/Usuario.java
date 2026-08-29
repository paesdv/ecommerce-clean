package com.ecommerce.clean.usuario.domain;

import java.util.UUID;
import java.util.regex.Pattern;

public class Usuario {

    private UUID id;
    private String nome;
    private String email;
    private String senha;
    private Role role;

    public Usuario(UUID id, String nome, String email, String senha, Role role){
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






}
