package com.example.coach.controleur;

import static org.junit.Assert.*;

import org.junit.Test;

public class ControleTest {


    float taille = 156;
    int age = 21;
    int poids = 200;
    int sexe = 1;


    private static Controle laInstance = Controle.getInstance();



    @Test
    public void getInstance() {
        boolean a  = false;
        if (laInstance != null) {
            a = true;
        }
        assertEquals(false, a);
    }

    @Test
    public void getProfil() {
    }

    @Test
    public void creerProfil() {
        boolean b = false;
        laInstance.creerProfil(152, 152, 150, 1);
        b = laInstance.getProfil();
        assertEquals(false, b)
      ;
    }

    @Test
    public void getImg() {
        laInstance.creerProfil(152, 152, 150, 1);
        float Img = laInstance.getImg();
        assertEquals(taille,Img , (float)1);
    }

    @Test
    public void getMessage() {
        laInstance.creerProfil(152, 152, 150, 1);
        String message = laInstance.getMessage();
        assertEquals(taille, message);

    }
    @Test
    public void getAttributes(){
        String a  = laInstance.getAttributes();
        assertEquals(a, "pourquoi pas");
    }
}


