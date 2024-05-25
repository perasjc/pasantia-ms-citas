package com.unir.citas.controller;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.Resource;
//import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unir.citas.dto.ConsultaListaExamenDTO;
import com.unir.citas.dto.ConsultaResumenDTO;
import com.unir.citas.dto.FiltroConsultaDTO;
import com.unir.citas.exception.ModelNotFoundException;
//import com.unir.citas.model.Archivo;
import com.unir.citas.model.ConsultaPaciente;
import com.unir.citas.service.IConsultaPacienteService;
//import com.unir.citas.service.IArchivoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

	@Autowired
	private IConsultaPacienteService service;
	
	
//	@Autowired
//	private IArchivoService serviceArchivo;


	@GetMapping
	public ResponseEntity<List<ConsultaPaciente>> listar() {
		List<ConsultaPaciente> lista = service.listar();
		return new ResponseEntity<List<ConsultaPaciente>>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ConsultaPaciente> leerPorId(@PathVariable("id") Long id) {
		ConsultaPaciente obj = service.leerPorId(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<ConsultaPaciente>(obj, HttpStatus.OK);
	}

	/*@GetMapping("/hateoas/{id}")
	public Resource<Consulta> leerPorIdHateoas(@PathVariable("id") Integer id) {
		Consulta obj = service.leerPorId(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		}

		Resource<Consulta> resource = new Resource<Consulta>(obj);
		// localhost:8080/pacientes/{id}
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).leerPorId(id));
		resource.add(linkTo.withRel("consulta-resource"));
		return resource;

	}***/

	/*@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ConsultaDTO> listarHateoas() {
		List<Consulta> consultas = new ArrayList<>();
		List<ConsultaDTO> consultasDTO = new ArrayList<>();
		consultas = service.listar();

		for (Consulta c : consultas) {
			ConsultaDTO d = new ConsultaDTO();
			d.setIdConsulta(c.getIdConsulta());
			d.setMedico(c.getMedico());
			d.setPaciente(c.getPaciente());

			// localhost:8080/consultas/1
			ControllerLinkBuilder linkTo = linkTo(methodOn(ConsultaController.class).leerPorId((c.getIdConsulta())));
			d.add(linkTo.withSelfRel());
			consultasDTO.add(d);

			// pacientes/2
			ControllerLinkBuilder linkTo1 = linkTo(
					methodOn(PacienteController.class).leerPorId((c.getPaciente().getIdPaciente())));
			d.add(linkTo1.withSelfRel());
			consultasDTO.add(d);

			ControllerLinkBuilder linkTo2 = linkTo(
					methodOn(MedicoController.class).leerPorId((c.getMedico().getIdMedico())));
			d.add(linkTo2.withSelfRel());

			consultasDTO.add(d);
		}

		return consultasDTO;
	}*/

	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody ConsultaListaExamenDTO obj) {
		ConsultaPaciente paciente = service.registrarTransaccional(obj);
		// localhost:8080/pacientes/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(paciente.getIdConsultaPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<Object> modificar(@Valid @RequestBody ConsultaPaciente pac) {
		service.modificar(pac);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Long id) {
		ConsultaPaciente obj = service.leerPorId(id);
		if (obj == null) {
			throw new ModelNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
		return new ResponseEntity<Object>(obj, HttpStatus.OK);
	}

	@PostMapping("/buscar")
	public ResponseEntity<List<ConsultaPaciente>> buscar(@RequestBody FiltroConsultaDTO filtro) {
		List<ConsultaPaciente> consultas = new ArrayList<>();

		if (filtro != null) {
			if (filtro.getFechaConsulta() != null) {
				consultas = service.buscarFecha(filtro);
			} else {
				consultas = service.buscar(filtro);
			}
		}
		return new ResponseEntity<List<ConsultaPaciente>>(consultas, HttpStatus.OK);
	}
	
	/*@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<ConsultaResumenDTO>> listarResumen() {
		List<ConsultaResumenDTO> consultas = new ArrayList<>();
		consultas = service.listarResumen();
		return new ResponseEntity<List<ConsultaResumenDTO>>(consultas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/generarReporte", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> generarReporte(){
		byte[] data = null;
		data = service.generarReporte();
		return new ResponseEntity<byte[]>(data, HttpStatus.OK);
	}
	
	@PostMapping(value = "/guardarArchivo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> guardarArchivo(@RequestParam("file") MultipartFile file) throws IOException{
		int rpta = 0;
		Archivo ar = new Archivo();
		ar.setFiletype(file.getContentType());
		ar.setFilename(file.getName());
		ar.setValue(file.getBytes());
		rpta = serviceArchivo.guardar(ar);
		
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);	
	}
	
	@GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {
				
		byte[] arr = serviceArchivo.leerArchivo(idArchivo); 

		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}*/
	
}
