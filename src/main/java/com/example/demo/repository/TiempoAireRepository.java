package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.TiempoAire;

public interface TiempoAireRepository extends JpaRepository<TiempoAire, String>{
	
	
	@Query(value = "select * from tiempo_aire  WHERE fecha BETWEEN :fechaI AND :fechaF", nativeQuery = true)
	List<TiempoAire> findByfechaBetween(@Param("fechaI") String fechaInicial, @Param("fechaF") String fechaFinal);

	@Query(value = "select compania, monto, count(monto) as total from tiempo_aire where fecha BETWEEN :fechaI\r\n"
			+ "and :fechaF group by  monto, compania", nativeQuery = true)
	List<String> findByfecha(@Param("fechaI") String fechaInicial, @Param("fechaF") String fechaFinal);
	

	@Query(value = "select TIMESTAMPDIFF(MINUTE,(select max(fecha) from tiempo_aire \r\n"
			+ "where telefono = :telefono and monto=:monto),:fecha) as minutos \r\n"
			+ "from tiempo_aire where telefono = :telefono and monto=:monto group by telefono UNION\r\n"
			+ "(SELECT 16) LIMIT 1", nativeQuery = true)
	int getMinutos(String telefono, Long monto, String fecha);

	
	
}

	
