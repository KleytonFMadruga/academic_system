package com.kleyton.academic_system.model;

import java.io.Serializable;
import java.util.Objects;

public class Professor implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private Integer siape;
	
	public Professor(String nome, Integer siape) {
		this.nome = nome;
		this.siape = siape;
	}
	public Professor() {
		this.nome = "";
		this.siape = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getSiape() {
		return siape;
	}

	public void setSiape(Integer siape) {
		this.siape = siape;
	}
	@Override
	public int hashCode() {
		return Objects.hash(siape);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		return Objects.equals(siape, other.siape);
	}
	
	
}
