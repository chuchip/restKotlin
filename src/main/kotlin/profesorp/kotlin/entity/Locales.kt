package profesorp.kotlin.entity

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.Entity;
import javax.persistence.Basic;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty

@Entity
@Table(name = "locales")

data class Locales  (@Id  @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
	@JsonProperty(value = "codigo")
    @Column(name = "loc_codi") val codigo: String,
	@JsonProperty(value = "nombre")
    @Column(name = "nombre") val nombre: String 
   )
{
	
}