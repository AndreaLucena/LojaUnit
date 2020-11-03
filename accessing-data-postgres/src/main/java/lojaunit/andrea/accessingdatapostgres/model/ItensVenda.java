package lojaunit.andrea.accessingdatapostgres.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity // This tells Hibernate to make a table out of this class
@IdClass (ItensVendaId.class)
public class ItensVenda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idItensVenda;
	
	private Integer quantidade;
	
	private double valorUnitario;
	
	@Id
	private long idVendas;
	
	@Id
	private long idProduto;
	

	public Integer getIdItensVenda() {
		return idItensVenda;
	}

	public void setIdItensVenda(Integer idItensVenda) {
		this.idItensVenda = idItensVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
}

@Embeddable
class ItensVendaId{
	
	private Integer idVendas;
	
	private Integer idProduto;

	public ItensVendaId() { }
	public ItensVendaId(Integer idVendas, Integer idProduto){

		this.idProduto = idProduto;
		this.idVendas = idVendas;
	}
	public Integer getIdVendas() {
		return idVendas;
	}
	public void setIdVendas(Integer idVendas) {
		this.idVendas = idVendas;
	}
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
}
