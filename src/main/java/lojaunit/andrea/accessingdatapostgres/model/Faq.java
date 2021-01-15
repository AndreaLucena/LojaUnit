package lojaunit.andrea.accessingdatapostgres.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Faq {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idFaq;

	private Date dataHora;
	  
	private String texto;
	
	@OneToMany(mappedBy = "idProduto")
	private List<Produto>ListaProduto;

	public Integer getIdFaq() {
		return idFaq;
	}

	public void setIdFaq(Integer idFaq) {
		this.idFaq = idFaq;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}