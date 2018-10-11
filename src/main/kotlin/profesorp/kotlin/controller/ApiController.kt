package profesorp.kotlin.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import profesorp.kotlin.entity.Locales
import profesorp.kotlin.exceptions.ConflictException
import profesorp.kotlin.exceptions.NotFoundException
import profesorp.kotlin.repository.LocaleRepository
import java.net.URI

@RestController
@RequestMapping("/api/")
class ApiController {

	@Autowired
	lateinit var localeRepository: LocaleRepository
	
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/")
	fun getAll(): Iterable<Locales>
	{
		return localeRepository.findAll();		
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/{codigo}/{nombre}")
	fun getByQuery(@PathVariable codigo:String,@PathVariable nombre:String): Iterable<Any>
	{
		return localeRepository.findLike("%"+codigo+"%","%"+nombre.toUpperCase()+"%");	
//		return localeRepository.findByCodigo("%"+codigo+"%");//,"%"+nombre.toUpperCase()+"%");	
	}
	
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/{codigo}")
	fun getByCodigo(@PathVariable codigo:String):Locales
	{
		return localeRepository.findById(codigo).orElseThrow({  ->  NotFoundException(codigo) });	
	}
	
	@CrossOrigin("http://localhost:4200")
	@PostMapping("/")	
	fun insertar(@RequestBody locales:Locales): ResponseEntity<Any>
	{
		if (localeRepository.existsById(locales.codigo ) )	
			return ResponseEntity(HttpStatus.CONFLICT);
		
		localeRepository.save(locales)
		
		return ResponseEntity
			.created( URI("/api/"+locales.codigo)).body("");
	}
	@CrossOrigin("http://localhost:4200")
	@DeleteMapping ("/{codigo}")
	fun deleteByCodigo(@PathVariable codigo:String):ResponseEntity<Any>
	{
		if (!localeRepository.existsById(codigo) )	
			throw NotFoundException(codigo)
		localeRepository.deleteById(codigo);
		return ResponseEntity( HttpStatus.OK)
	}
	
	@CrossOrigin("http://localhost:4200")
	@PutMapping ("/{codigo}")
	fun update(@PathVariable codigo:String,@RequestBody locales:Locales):ResponseEntity<Any>
	{
		if (!localeRepository.existsById(codigo) )	
			throw NotFoundException(codigo)
		
		if (!codigo.equals(locales.codigo))
			throw ConflictException(codigo)
		localeRepository.save(locales);
		return ResponseEntity( HttpStatus.OK)
	}
	
}