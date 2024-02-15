package com.example.coach.controleur;


import com.example.coach.modele.Profil;

//Classe écrite selon le patterne singleton (classe voué à créer une seule instance)
public final class Controle {

    private static Controle instance = null;
    private static Profil profil;

    private Controle() {
        super();
    }

    public final static Controle getInstance(){
        if (instance == null) {

            instance = new Controle();
        }
        return instance;
    }

    public boolean getProfil(){
        boolean a = false;
        if (profil != null){
            a = true;
        }
        return a;
    }

    public void creerProfil(int poids, int taille, int age, int sexe) {

        profil =  new Profil(poids, taille, age, sexe);

    }

    public float getImg() {
        float a = 0f;
        if (profil != null){
            a = profil.getImg();
        }
        return a;
    }

    public String getAttributes(){
        int a = profil.getPoids();
        int b = profil.getTaille();
        int c = profil.getAge();
        int d = profil.getSexe();
        String e = String.valueOf("poids" + a + "taille" + b + "age" + c + "sexe" + d);
        return e;
    }

    public String getMessage(){
        String a = "";
        if (profil != null){
            a = profil.getMessage();
        }
        return a;
    }



}
