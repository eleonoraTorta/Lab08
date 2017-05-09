package it.polito.tdp.borders.model;

public class Border {
	
	private Country stato1;
	private Country stato2;
	private int anno;
	private int diade;
	
	/**
	 * @param stato1
	 * @param stato2
	 * @param anno
	 * @param diade
	 */
	public Border(Country stato1, Country stato2, int anno, int diade) {
		super();
		this.stato1 = stato1;
		this.stato2 = stato2;
		this.anno = anno;
		this.diade = diade;
	}

	/**
	 * @return the stato1
	 */
	public Country getStato1() {
		return stato1;
	}

	/**
	 * @param stato1 the stato1 to set
	 */
	public void setStato1(Country stato1) {
		this.stato1 = stato1;
	}

	/**
	 * @return the stato2
	 */
	public Country getStato2() {
		return stato2;
	}

	/**
	 * @param stato2 the stato2 to set
	 */
	public void setStato2(Country stato2) {
		this.stato2 = stato2;
	}

	/**
	 * @return the anno
	 */
	public int getAnno() {
		return anno;
	}

	/**
	 * @param anno the anno to set
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}

	

	/**
	 * @return the diade
	 */
	public int getDiade() {
		return diade;
	}

	/**
	 * @param diade the diade to set
	 */
	public void setDiade(int diade) {
		this.diade = diade;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Border [stato1=" + stato1 + ", stato2=" + stato2 + ", anno=" + anno + ", diade=" + diade + "] \n";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + diade;
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
		Border other = (Border) obj;
		if (diade != other.diade)
			return false;
		return true;
	}
	
	
	

}
