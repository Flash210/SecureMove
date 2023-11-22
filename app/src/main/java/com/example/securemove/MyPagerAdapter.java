package com.example.securemove;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;

    public MyPagerAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View layout = inflater.inflate(R.layout.cours, container, false);

        // Find TextViews in your_layout.xml
        TextView introductionTxt = layout.findViewById(R.id.introductionTxt);
        TextView descTxt = layout.findViewById(R.id.descTxt);
        TextView exmTxt = layout.findViewById(R.id.exmTxt);
        TextView exmN = layout.findViewById(R.id.exmN);

        // Update text values based on position
        switch (position) {
            case 0:
                // Set text for the first screen
                introductionTxt.setText("Introduction au Cryptage avec la Méthode César");
                descTxt.setText("Le Chiffre de César, nommé d'après Jules César, est l'une des techniques de chiffrement les plus simples et les plus anciennes connues. Il s'agit d'un type de chiffrement par substitution où chaque lettre du texte en clair est décalée d'un certain nombre de positions vers le bas ou vers le haut de l'alphabet. La clé dans le Chiffre de César est le nombre de positions que chaque lettre est décalée, et on l'appelle généralement le \"décalage\" ou la \"clé\".");
                exmTxt.setText("Exemple de Chiffrement de César");
                exmN.setText(" Cryptons le mot \"Isima\" en utilisant le Chiffre de César avec un décalage de 3.\n " +
                        "\nI -> L\n" +
                                "s -> v\n" +
                                "i -> l\n" +
                                "m -> p\n" +
                                "a -> x \n"
                        + "Mot Crypté = "+
                        "Lvpxp\n"
                        );
                break;
            case 1:
                // Set text for the second screen
                introductionTxt.setText("Introduction au Cryptage avec la Méthode RSA");
                introductionTxt.setTextColor(Color.parseColor("#22A39F"));

                descTxt.setText("Le chiffre de Vigenère est une méthode de chiffrement du texte alphabétique utilisant une forme simple de substitution polyalphabétique. Nommé d'après le diplomate et cryptographe français Blaise de Vigenère, ce chiffre constitue une amélioration significative par rapport au chiffre de César, qui est un type de chiffrement de substitution où chaque lettre du texte en clair est décalée d'un certain nombre de positions vers le haut ou vers le bas dans l'alphabet.");
                exmTxt.setText("Exemple de Chiffrement RSA");
                exmTxt.setTextColor(Color.parseColor("#22A39F"));
                exmN.setText("Supposons que nous voulons chiffrer le message \"CRYPTAGE\" avec la clé \"SECURITE\". Le chiffrement de Vigenère fonctionne en répétant la clé pour qu'elle ait la même longueur que le message, puis en décalant chaque lettre du message par le décalage correspondant dans la clé.\n" +
                        "\n" +
                        "Message : C R Y P T A G E\n" +
                        "\n" +
                        "Clé : S E C U R I T E\n" +
                        "\n" +
                        "Message Chiffré : X U Z F I W I K");

                break;
            case 2:
                // Set text for the third screen
                introductionTxt.setText("Introduction au Cryptage avec la Méthode Affine");
                introductionTxt.setTextColor(Color.parseColor("#FF6000"));

                descTxt.setText("La méthode affine est un algorithme de cryptage qui fait partie de la famille des chiffrements par substitution. Elle combine deux opérations mathématiques, à savoir la multiplication et l'addition modulo une certaine valeur, pour transformer les caractères d'un texte en clair en caractères chiffrés. Cette méthode offre une sécurité relativement plus élevée que certains chiffrements plus simples.");
                exmTxt.setText("Exemple de Chiffrement Affine");
                exmTxt.setTextColor(Color.parseColor("#FF6000"));

                exmN.setText("Supposons que nous voulions chiffrer le mot \"HELLO\" en utilisant la méthode affine avec les clés\n" +
                        "a=5\n" +
                        "et\n" +
                        "b=8\n" +
                        " dans l'alphabet anglais, où chaque lettre est représentée par un nombre de 0 à 25\n"+
                   "Assignation des valeurs numériques aux lettres :\n" +
                           "\n" +
                           "H → 7 | " +
                           "E → 4 | " +
                           "L → 11 | " +
                           "L → 11 | " +
                           "O → 14 | "+"Application de la formule de chiffrement :\n" +
                        "E(x)=(ax+b)"+
                        "\n"+"" +
                        "Conversion des valeurs chiffrées en lettres :\n" +
                        "15 → P | " +
                        "4 → E | " +
                        "13 → N | " +
                        "13 → N | " +
                        "10 → K"
                );
                break;
        }

        container.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return 3; // Number of screens
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
