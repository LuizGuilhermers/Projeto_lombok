package com.exemplolombook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplolombook.entities.Usuario;
import com.exemplolombook.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

		private final UsuarioService usuarioService;

	@Autowired
	public UsuarioController (UsuarioService usuarioservice) {
		this.usuarioService=usuarioservice;
	}

	@GetMapping("/(id)")
	public ResponseEntity<Usuario> buscaUsuarioControlId (@PathVariable Long id) { 
		Usuario usuario = usuarioService.buscaUsuariold(id);
	if (usuario != null) {
		return ResponseEntity.ok (usuario);
	}
	else {
		return ResponseEntity.notFound().build();
	}
	}


	@GetMapping("/")
		public ResponseEntity<List<Usuario>> buscaTodosUsuariosControl() {
		List<Usuario> Usuarios = usuarioService.buscaTodosUsuarios();
		return ResponseEntity.ok (Usuarios);
	}
	
	@PostMapping ("/")
	public ResponseEntity<Usuario> salvaUsuarioControl (@RequestBody @Valid Usuario Usuario){
		Usuario salvaUsuario = usuarioService.salvaUsuario (Usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaUsuario);
	}
	
	@PutMapping ("/{id}")
	public ResponseEntity<Usuario> alteraUsuarioControl (@PathVariable Long id, @RequestBody @Valid Usuario Usuario) {
		Usuario alteraUsuario = usuarioService.alterarUsuario(id, Usuario);
		if (alteraUsuario !=null) {
			return ResponseEntity.ok(Usuario);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping ("/{id}") 
	public ResponseEntity<Usuario> apagaUsuarioControl (@PathVariable Long id){
		boolean apagar = usuarioService.apagarUsuario(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} 
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
