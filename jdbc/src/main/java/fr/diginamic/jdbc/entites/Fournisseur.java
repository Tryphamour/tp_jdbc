package fr.diginamic.jdbc.entites;

import java.util.concurrent.atomic.AtomicInteger;

public class Fournisseur {

	private static final AtomicInteger ID_FACTORY = new AtomicInteger();
	private final int id;
	private String nom;

	public Fournisseur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public Fournisseur() {
		id = ID_FACTORY.getAndIncrement();
	}

	public final int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + "]";
	}
}