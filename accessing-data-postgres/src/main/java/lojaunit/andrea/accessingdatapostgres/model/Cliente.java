package lojaunit.andrea.accessingdatapostgres.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Cliente {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer idCliente;

  private String nome;
  
  private Integer cpf;

  private String email;
  
  private Date dataNascimento;
  
  private String sexo;
  
  private String nomeSocial;
  
 private String apelido;
 
 private Integer telefone;
 

public Integer getIdCliente() {
	return idCliente;
}

public void setIdCliente(Integer idCliente) {
	this.idCliente = idCliente;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Integer getCpf() {
	return cpf;
}

public void setCpf(Integer cpf) {
	this.cpf = cpf;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Date getDataNascimento() {
	return dataNascimento;
}

public void setDataNascimento(Date dataNascimento) {
	this.dataNascimento = dataNascimento;
}

public String getSexo() {
	return sexo;
}

public void setSexo(String sexo) {
	this.sexo = sexo;
}

public String getNomeSocial() {
	return nomeSocial;
}

public void setNomeSocial(String nomeSocial) {
	this.nomeSocial = nomeSocial;
}

public String getApelido() {
	return apelido;
}

public void setApelido(String apelido) {
	this.apelido = apelido;
}

public Integer getTelefone() {
	return telefone;
}

public void setTelefone(Integer telefone) {
	this.telefone = telefone;
}
 
}

 