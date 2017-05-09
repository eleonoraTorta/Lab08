package it.polito.tdp.borders.model;

public class Country {
	
	private int codice;
	private String abbreviazione;
	private String nome;
	
	/**
	 * @param codice
	 * @param abbreviazione
	 * @param nome
	 */
	public Country(int codice, String abbreviazione) {
		super();
		this.codice = codice;
		this.abbreviazione = abbreviazione;
		
	}

	/**
	 * @return the codice
	 */
	public int getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(int codice) {
		this.codice = codice;
	}

	/**
	 * @return the abbreviazione
	 */
	public String getAbbreviazione() {
		return abbreviazione;
	}

	/**
	 * @param abbreviazione the abbreviazione to set
	 */
	public void setAbbreviazione(String abbreviazione) {
		this.abbreviazione = abbreviazione;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [codice=" + codice + ", abbreviazione=" + abbreviazione + ", nome=" + nome + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codice;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (codice != other.codice)
			return false;
		return true;
	}
	
	

}
