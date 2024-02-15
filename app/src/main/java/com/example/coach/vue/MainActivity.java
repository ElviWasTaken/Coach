package com.example.coach.vue;

import static java.lang.Float.parseFloat;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coach.R;
import com.example.coach.controleur.Controle;

public class MainActivity extends AppCompatActivity {

    private EditText txtPoids;
    private EditText txtTaille;
    private EditText txtAge;
    private RadioButton rdHomme;
    private TextView lblIMG;
    private ImageView imgSmiley;
    private Button btnCalc;

    private static Controle controle;

    //XML FIELD LISTENED AND CONVERTED IN JAVA TYPES
    static int poids = 0;
    static int age = 0;
    static int taille = 0;
    static int sexe = 0;
    static float img = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {

        //LINK BETWEEN INTERFACE ELEMENTS(XML) AND BACK END(JAVA)
        txtPoids = (EditText) findViewById(R.id.txtPoids);
        txtTaille = (EditText) findViewById(R.id.txtTaille);
        txtAge = (EditText) findViewById(R.id.txtAge);
        rdHomme = (RadioButton) findViewById(R.id.rdHomme);
        lblIMG = (TextView) findViewById(R.id.lblIMG);
        imgSmiley = (ImageView) findViewById(R.id.imgSmiley);
        btnCalc  = (Button) findViewById(R.id.btnCalc);


        controle = controle.getInstance(); //récupération de l'instance déjà existante ou création d'une nouvelle

        ecouteCalcul(); // récupération des valeures saisies par l'utilisateur dans l'app vers leur variables respectives puis verifie que l'utilisateur a bien rentré quelque chose

        affichResult(poids, taille, age, sexe);
    }

    public void ecouteCalcul(){

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    poids = 200;//Integer.parseInt(txtPoids.getText().toString());
                    age = 21;//Integer.parseInt(txtPoids.getText().toString());
                    taille = 150;//Integer.parseInt(txtPoids.getText().toString());
                    sexe = 1;//booleanToInt(rdHomme.isChecked());
                }
                catch(Exception e){}
                if (poids == 0 || age == 0 || taille == 0) {
                    Toast.makeText(MainActivity.this, "veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "les champs ont bien été remplis", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void affichResult(int poids,int taille, int age, int sexe){
        controle.creerProfil(poids, taille, age, sexe);
        img = controle.getImg();      //récuperation de l'img calculé depuis le profil
        img = parseFloat((String.format("%.1f",img)));     // convertion de l'img 1 décimal après la virgule
        String message = controle.getMessage();
        String concatenatedImg = (img + message);//récuperation du message définis en fonction de la valeure de retour de l'img
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controle.getInstance() != null ){
                    Toast.makeText(MainActivity.this, controle.getAttributes(), Toast.LENGTH_SHORT).show();
                }
                if (controle.getInstance() == null){
                    Toast.makeText(MainActivity.this, "instance offline", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //switch case selection de l'image du résultat
        switch(message){
            case("Maigre"): imgSmiley.setImageResource(R.drawable.koro2);
            break;
            case ("Surpoids"): imgSmiley.setImageResource(R.drawable.koro3);
            break;
            case("dans la moyenne"): imgSmiley.setImageResource(R.drawable.koro1);
        }
        //switch case selection de la couleur du résultat
        switch(message){
            case("Maigre"): lblIMG.setTextColor(Color.RED);
                break;
            case ("Surpoids"): lblIMG.setTextColor(Color.RED);
                break;
            case("dans la moyenne"): lblIMG.setTextColor(Color.GREEN);
        }

        lblIMG.setText(String.valueOf(concatenatedImg));
    }


    //This method allow me to use the xml radio field result as an integer
    public int booleanToInt(boolean foo) {
        return (foo) ? 1 : 0;
    }

}