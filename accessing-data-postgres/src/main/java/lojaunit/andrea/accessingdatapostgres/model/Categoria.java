package lojaunit.andrea.accessingdatapostgres.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Categoria {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer idCategoria;

	  private String nome;
	  
	  private boolean ativo;
	  
	  @OneToMany(mappedBy = "idProduto")
		private List<Produto>ListaProduto;

	public List<Produto> getListaProduto() {
		return ListaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		ListaProduto = listaProduto;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
	  
	  