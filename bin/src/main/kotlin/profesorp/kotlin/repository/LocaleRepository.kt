package profesorp.kotlin.repository

import org.springframework.data.repository.CrudRepository;
import profesorp.kotlin.entity.Locales
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.jpa.repository.JpaRepository

interface LocaleRepository : JpaRepository<Locales,String> {
}