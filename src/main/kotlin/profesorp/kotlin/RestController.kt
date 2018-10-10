package profesorp.kotlin

import org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Autowired
import profesorp.kotlin.repository.LocaleRepository
import org.springframework.data.domain.Sort;
import profesorp.kotlin.entity.Locales
import org.springframework.web.bind.annotation.PathVariable
import java.util.Optional
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity.BodyBuilder
import java.net.URI
import org.springframework.web.util.UriBuilder
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/")
class RestController {

	@Autowired
	lateinit var localeRepository: LocaleRepository
	
	
	
	@GetMapping(value="/")
	fun getAll(): List<Locales>
	{
		return localeRepository.findAll();
		
	}
	
	
	@GetMapping(value = "/{codigo}")
	fun getByCodigo(@PathVariable codigo:String):Locales
	{
		return localeRepository.findById(codigo).orElseThrow({  ->  NotFoundException(codigo) });
	
	}
	@PostMapping()
	fun insertar(locales:Locales): ResponseEntity<Any>
	{
		if (localeRepository.existsById(locales.locCodi ) )	
			return ResponseEntity.badRequest()
            .body("Codigo de Pais Ya existe");
		
		localeRepository.save(locales)
		
		return ResponseEntity
			.created( URI("/api/")).body("Codigo de Pais CREADO")		
	}
}