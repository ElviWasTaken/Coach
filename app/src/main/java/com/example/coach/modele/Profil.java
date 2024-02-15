package com.example.coach.modele;

public class Profil {

    public int poids;
    public int taille;
    public int age;
    public int sexe;
    public float img = 0;
    public String message = "";


    //CONSTANTES

    private static final Integer minFemme = 15; // maigre si en dessous
    private static final Integer maxFemme = 30; // gros si au dessus
    private static final Integer minHomme = 10; // maigre si en dessous
    private static final Integer maxHomme = 25; // gros si au dessus

    //CONSTRUCTEUR

    public Profil(int poids, int taille, int age, int sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
    }

    //GETTERS

    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public int getSexe() {
        return sexe;
    }

    public float getImg() {
        float a = 1.2f;
        float b = 0.23f;
        float c = 10.83f;
        float d = ((float)5.4f);
        float i = 0;

        if (img == 0) {
            float tailleEnMetres = taille / 100.0f;

            // Calcul de l'attribut img selon la formule donnée
            img = (float) ((1.2 * poids / Math.pow(tailleEnMetres, 2)) + (0.23 * age) - (10.83 * sexe) - 5.4);
        };
        return img;
    }



    public String getMessage(){
        img = getImg();

        if (message == ""){
            if (sexe == 1){
                if (img < minHomme){
                    message = ("Maigre");
                }
                if(img > maxHomme){
                    message = ("Surpoids");
                }
                else{
                    message = ("dans la moyenne");
                }
            }
            else{
                if (img < minFemme){
                    message = ("Maigre");
                }
                if (img > maxFemme){
                    message = ("Surpoids");
                }
                else{
                    message = ("dans la moyenne");
                }
            }
        }
        return message;
    }

}
