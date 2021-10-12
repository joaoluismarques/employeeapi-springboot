package com.joaoluis.employeeapi.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Código do trabalhador")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Cpf dp trabalhador")
	@Column(unique=true)
	private String cpf;
	
	@ApiModelProperty(value = "Nome do trabalhador")
	private String name;
	
	@ApiModelProperty(value = "Gênero do trabalhador")
	private String gender;
	
	@ApiModelProperty(value ="Retorna o setor do trabalhador")
	@OneToOne(cascade = CascadeType.PERSIST)
	private Sector sector;
	
	@ApiModelProperty(value = "Retorna o cargo do trabalhador")
    @OneToOne(cascade = CascadeType.PERSIST)
	private Position position;
	
	public Worker() {		
	}

	public Worker(Long id, String cpf, String name, String gender, Sector sector, Position position) {
		this.id = id;
		this.cpf = cpf;
		this.name = name;
		this.gender = gender;
		this.sector = sector;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Sector getSector() {
		return sector;
	}
	
	@JsonIgnore
	public Position getPosition() {
		return position;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}
}
