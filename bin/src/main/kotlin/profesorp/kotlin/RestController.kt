package profesorp.kotlin
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
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

@RestController
@RequestMapping("/api/")
class RestController {

	@Autowired
	lateinit var localeRepository: LocaleRepository
	
	@GetMapping(value="/")
	fun getAll():Iterable<Locales>
	{
		return localeRepository.findAll(); 
	}
	
	
	@GetMapping(value = "/{codigo}")
	fun getByCodigo(@PathVariable codigo:String):Locales
	{
		return  localeRepository.findById(codigo).orElseThrow({  ->  NotFoundException(codigo) });
		
	}
}