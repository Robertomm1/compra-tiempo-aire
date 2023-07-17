package com.example.demo.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Companias;
import com.example.demo.model.Consultas;
import com.example.demo.model.TiempoAire;
import com.example.demo.model.TotalesVentas;
import com.example.demo.model.Paquetes;
import com.example.demo.model.Response;
import com.example.demo.repository.CompaniaRepoitory;
import com.example.demo.repository.PaquetesRepository;
import com.example.demo.repository.TiempoAireRepository;

@Service
public class TiempoAireService {

	@Autowired
	private TiempoAireRepository tiempoAireRepository;

	@Autowired
	private CompaniaRepoitory companiaRepoitory;

	@Autowired
	private PaquetesRepository paquetesRepository;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	DateTimeFormatter dtFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public List<Paquetes> getPaquetes() {
		return (List<Paquetes>) paquetesRepository.findAll();
	}

	public List<Companias> getCompanias() {
		return (List<Companias>) companiaRepoitory.findAll();
	}

	public Response save(TiempoAire telefono) {
		Response resultado = new Response();
		telefono.setFecha(dtf.format(LocalDateTime.now()));
		int minutos = tiempoAireRepository.getMinutos(telefono.getTelefono(), telefono.getMonto(), telefono.getFecha());

		if (minutos >= 15) {

			tiempoAireRepository.save(telefono);
			resultado.setMensaje("Registo con exito");
			resultado.setStatus("Exito");

		} else {
			resultado.setMensaje("No se permite recargar el mismo paquete en menos de 15 min");
			resultado.setStatus("Error");
		}
		return resultado;

	}

	public List<TiempoAire> getCompras(Consultas fechas) {
		return tiempoAireRepository.findByfechaBetween(fechas.getFechaInicial(), fechas.getFechaFinal());

	}

	public TotalesVentas getComprasDia() {
		TotalesVentas resultado = new TotalesVentas();
		String fecha = dtFecha.format(LocalDateTime.now());
		String fechaFinal =dtf.format(LocalDateTime.now());
		String fechaInicial = fecha+" 00:00:00";
		long total = tiempoAireRepository.count();
		List<String> lista = tiempoAireRepository.findByfecha(fechaInicial,fechaFinal);
		resultado.setVentas(lista);
		resultado.setTotal_ventas(total);
		return resultado;
	}

}
