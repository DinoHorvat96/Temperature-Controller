package hr.veleri.controller;


import java.util.ArrayList;
import java.util.List;

import hr.veleri.model.Model;

public class TemperaturaController {
	private List<Model> listaOcitanja = new ArrayList<Model>();
	
	public void kreirajDnevnuTemperaturu (String nazivMjeseca, int danUMjesecu, float jutarnjaTemp, float popodnevnaTemp, float vecernjaTemp){
		Model korisnickoOcitanje = new Model();
		
		korisnickoOcitanje.setNazivMjeseca(nazivMjeseca);
		korisnickoOcitanje.setDanUMjesecu(danUMjesecu);
		korisnickoOcitanje.setJutarnjaTemp(jutarnjaTemp);
		korisnickoOcitanje.setPopodnevnaTemp(popodnevnaTemp);
		korisnickoOcitanje.setVecernjaTemp(vecernjaTemp);
		
		listaOcitanja.add(korisnickoOcitanje);
	}
	
	public float izracunProsjecnihJutarnjih(){
		
	
		float sumaTemp = 0;
	
		for (int indeks=1; indeks < listaOcitanja.size(); indeks++) {
			sumaTemp = sumaTemp + listaOcitanja.get(indeks).getJutarnjaTemp();
			sumaTemp = sumaTemp/indeks;
		}
		
		return sumaTemp;
	}
}
