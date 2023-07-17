package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Companias;
import com.example.demo.model.Consultas;
import com.example.demo.model.Paquetes;
import com.example.demo.model.Response;
import com.example.demo.model.TiempoAire;
import com.example.demo.model.TotalesVentas;
import com.example.demo.service.TiempoAireService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("compra")
public class TempoAireController {

	@Autowired
	private TiempoAireService tiempoAireService;

	@PostMapping(value = "/tiempo-aire")
	public ResponseEntity<Response> comprarTiempo(@Valid @RequestBody TiempoAire telefono) {
		Response resultado = tiempoAireService.save(telefono);
		return ResponseEntity.status(HttpStatus.OK).body(resultado);
	}

	@PostMapping("/paquetes")
	ResponseEntity<List<Paquetes>> consultaPaquetes() {
		List<Paquetes> listaPaquetes = tiempoAireService.getPaquetes();
		return ResponseEntity.status(HttpStatus.OK).body(listaPaquetes);
	}

	@PostMapping("/companias")
	ResponseEntity<List<Companias>> consultaCompanias() {
		List<Companias> listaCompanias = (List<Companias>) tiempoAireService.getCompanias();
		return ResponseEntity.status(HttpStatus.OK).body(listaCompanias);
	}
	
	@PostMapping("/consultaCompras")
	ResponseEntity<List<TiempoAire>> consultaCompras(@Valid @RequestBody Consultas fechas) {
		List<TiempoAire> listaCompanias = (List<TiempoAire>) tiempoAireService.getCompras(fechas);
		return ResponseEntity.status(HttpStatus.OK).body(listaCompanias);
	}
	
	@PostMapping("/consultaDia")
	ResponseEntity<TotalesVentas> consultaDia() {
		TotalesVentas listaCompanias =  tiempoAireService.getComprasDia();
		return ResponseEntity.status(HttpStatus.OK).body(listaCompanias);
	}

}
