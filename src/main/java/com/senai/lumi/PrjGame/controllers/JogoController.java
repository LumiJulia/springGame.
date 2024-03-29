package com.senai.lumi.PrjGame.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.lumi.PrjGame.entities.Jogo;
import com.senai.lumi.PrjGame.services.JogoServices;



@RestController
@RequestMapping("/jogos")
public class JogoController {
	
	@GetMapping("/home")
    public String paginaInicial() {
        return "index";
    }
	
	private final JogoServices jogoServices;
	
	@Autowired
	public JogoController(JogoServices jogoServices) {
		this.jogoServices = jogoServices;		
	}
	@GetMapping("/{id}")	
    public ResponseEntity<Jogo> getJogo(@PathVariable Long id) {
        Jogo jogo = jogoServices.getJogoById(id);
        if (jogo != null) {
            return ResponseEntity.ok(jogo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }	
	@PostMapping
	public Jogo createJogo(@RequestBody Jogo jogo) {
		return jogoServices.savejogo(jogo);
	}
	
	@GetMapping
	public List<Jogo> getAllJogos(){
		return jogoServices.getAllJogos();
	}
	
	@DeleteMapping("/{id}")
	public void deleteJogo(@PathVariable Long id) {
		jogoServices.deleteJogo(id);
	}
	
	
	

}

