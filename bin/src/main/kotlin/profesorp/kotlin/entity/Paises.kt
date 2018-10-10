package profesorp.kotlin.entity

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
class Paises (
		  @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "pai_inic")
    val paiInic:String,
	@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "pai_nomb")
    val  paiNomb:String,
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "pai_nomcor")
	val paiNomcor:String,
	@Basic(optional = false)
    @NotNull
    @Column(name = "pai_activ")
    val paiActiv:Short,
    @JoinColumn(name = "loc_codi", referencedColumnName = "loc_codi")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    val locCodi:Locales
)

{
}