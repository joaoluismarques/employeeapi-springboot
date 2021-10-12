package com.joaoluis.employeeapi.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_sector")
public class Sector implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Código do setor")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(value = "Nome do setor")
	@Column(unique=true)
	private String name;
	
	@ApiModelProperty(value = "Retorna uma lista de cargos do setor")
	@OneToMany	
	private Set<Position> positions = new HashSet<>();
	
	public Sector() {		
	}

	public Sector(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Set<Position> getPositions() {		
		return positions;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sector other = (Sector) obj;
		return Objects.equals(id, other.id);
	}
}
