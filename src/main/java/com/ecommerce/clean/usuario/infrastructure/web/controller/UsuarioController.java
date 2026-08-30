package com.ecommerce.clean.usuario.infrastructure.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.clean.usuario.application.usecase.AlterarEmailUseCase;
import com.ecommerce.clean.usuario.application.usecase.AlterarSenhaUseCase;
import com.ecommerce.clean.usuario.application.usecase.BuscarUsuarioUseCase;
import com.ecommerce.clean.usuario.application.usecase.CriarUsuarioUseCase;
import com.ecommerce.clean.usuario.application.usecase.DeletarUsuarioUseCase;
import com.ecommerce.clean.usuario.application.usecase.ListarUsuariosUseCase;
import com.ecommerce.clean.usuario.domain.Usuario;
import com.ecommerce.clean.usuario.infrastructure.web.dto.AtualizarEmailRequestDTO;
import com.ecommerce.clean.usuario.infrastructure.web.dto.AtualizarSenhaRequestDTO;
import com.ecommerce.clean.usuario.infrastructure.web.dto.CriarUsuarioRequestDTO;
import com.ecommerce.clean.usuario.infrastructure.web.dto.UsuarioResponseDTO;
import com.ecommerce.clean.usuario.infrastructure.web.mapper.UsuarioWebMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsuarioController {

    private final AlterarEmailUseCase alterarEmailUseCase;
    private final AlterarSenhaUseCase alterarSenhaUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;
    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final DeletarUsuarioUseCase deletarUsuarioUseCase;
    private final ListarUsuariosUseCase listarUsuariosUseCase;
    private final UsuarioWebMapper usuarioWebMapper;


    @PostMapping
public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody CriarUsuarioRequestDTO request){
    Usuario usuario = criarUsuarioUseCase.executar(
        request.nome(),
        request.email(),
        request.senha()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(usuarioWebMapper.toResponseDTO(usuario));
}

@GetMapping("/{id}")
public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable UUID id){
    Usuario usuario = buscarUsuarioUseCase.executar(id);
    return ResponseEntity.ok(usuarioWebMapper.toResponseDTO(usuario));
}

@GetMapping
public ResponseEntity<List<UsuarioResponseDTO>> listar(){
    List<UsuarioResponseDTO> usuarios = listarUsuariosUseCase.executar().stream()
        .map(usuarioWebMapper::toResponseDTO)
        .toList();
    return ResponseEntity.ok(usuarios);
}

@PatchMapping("/me/senha")
public ResponseEntity<Void> alterarSenha(@RequestBody AtualizarSenhaRequestDTO request){

    UUID idUsuarioLogado = null;

    alterarSenhaUseCase.executar(idUsuarioLogado, request.senhaAtual(), request.novaSenha());
    return ResponseEntity.noContent().build();
}

@PatchMapping("/me/email")
public ResponseEntity<Void> alterarEmail(
        
        @RequestBody AtualizarEmailRequestDTO request){

    UUID idUsuarioLogado = null; 

    alterarEmailUseCase.executar(idUsuarioLogado, request.senhaAtual(), request.novoEmail());
    return ResponseEntity.noContent().build();
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deletar(@PathVariable UUID id){
    deletarUsuarioUseCase.executar(id);
    return ResponseEntity.noContent().build();
}


}
