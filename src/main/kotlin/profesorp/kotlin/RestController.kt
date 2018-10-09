package profesorp.kotlin
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Autowired
import profesorp.kotlin.repository.LocaleRepository
import org.springframework.data.domain.Sort;
import profesorp.kotlin.entity.Locales

@RestController
@RequestMapping("/api/")
class RestController {

	@Autowired
	lateinit var localeRepository: LocaleRepository
	
	@RequestMapping(method = arrayOf(RequestMethod.GET),value="/")
	fun getAll():Iterable<Locales>
	{
		return localeRepository.findAll(); 
	}
}