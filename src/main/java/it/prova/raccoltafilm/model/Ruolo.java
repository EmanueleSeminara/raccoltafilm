package it.prova.raccoltafilm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ruolo")
public class Ruolo implements Comparable<Ruolo> {

	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_CLASSIC_USER = "ROLE_CLASSIC_USER";
	public static final String ROLE_VISITOR = "ROLE_VISITOR";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "codice")
	private String codice;

	public Ruolo() {
	}

	public Ruolo(String descrizione, String codice) {
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", descrizione=" + descrizione + ", codice=" + codice + "]";
	}

	@Override
	public int compareTo(Ruolo o) {
		return Long.compare(this.id, o.getId());
	}

}
