package com.example.coach.modele;

import junit.framework.TestCase;

public class ProfilTest extends TestCase {


    private Profil profile1 = new Profil(67, 165, 35, 1);

    private float img = (float)32.4;

    private String message  = ("Surpoids");

    private int taille = 165;

    public void testGetImg() {
        assertEquals(img, profile1.getImg(), (float)1);
    }

    public void testGetMessage() {
        assertEquals(message, profile1.getMessage());
    }


}