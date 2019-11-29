package com.gustavo.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//import lombok.Data;

//@Data
@Entity
public class Categoria implements Serializable{
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer IdCat;
		private String NomeCat;
		
		@ManyToMany(mappedBy="categorias")
		private List<Produtos> produtos = new ArrayList<>(); 
		
		public Categoria() {}

		public Categoria(Integer idCat, String nomeCat) {
			super();
			IdCat = idCat;
			NomeCat = nomeCat;
		}

		public Integer getIdCat() {
			return IdCat;
		}

		public void setIdCat(Integer idCat) {
			IdCat = idCat;
		}

		public String getNomeCat() {
			return NomeCat;
		}

		public void setNomeCat(String nomeCat) {
			NomeCat = nomeCat;
		}
		
		public List<Produtos> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produtos> produtos) {
			this.produtos = produtos;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((IdCat == null) ? 0 : IdCat.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Categoria other = (Categoria) obj;
			if (IdCat == null) {
				if (other.IdCat != null)
					return false;
			} else if (!IdCat.equals(other.IdCat))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Categoria [IdCat=" + IdCat + ", NomeCat=" + NomeCat + "]";
		}
		
		
				
}
