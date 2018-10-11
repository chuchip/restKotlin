package profesorp.kotlin.repository

import org.springframework.data.repository.CrudRepository;
import profesorp.kotlin.entity.Locales
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface LocaleRepository : CrudRepository<Locales,String> {
	@Query("SELECT l FROM Locales l where l.codigo like ?1 and upper(l.nombre) like ?2")
	fun findLike(codigo:String, nombre:String):Iterable<Locales>;
	fun findByCodigo(codigo:String):Iterable<Locales>;
}