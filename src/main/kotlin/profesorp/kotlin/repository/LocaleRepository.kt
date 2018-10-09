package profesorp.kotlin.repository

import org.springframework.data.repository.CrudRepository;
import profesorp.kotlin.entity.Locales
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pais", path = "pais")
interface LocaleRepository : PagingAndSortingRepository<Locales,String> {
}