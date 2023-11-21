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

                descTxt.setText("RSA (Rivest–Shamir–Adleman) est un algorithme de cryptage asymétrique.\n" +
                        "Processus de Chiffrement :\n" +
                        "\n" +
                        "Génération de Clé :\n" +
                        "\n" +
                        "Choisissez deux grands nombres premiers, p et q.\n" +
                        "Calculez n = p * q.\n" +
                        "Calculez la fonction totient d'Euler, φ(n) = (p-1)(q-1).\n" +
                        "Choisissez un entier e tel que 1 < e < φ(n) et e soit premier avec φ(n).\n" +
                        "Calculez la clé privée d telle que (d * e) % φ(n) = 1.\n" +
                        "Chiffrement :\n" +
                        "\n" +
                        "L'expéditeur obtient la clé publique du destinataire (e, n).\n" +
                        "Convertissez le message en clair M en un entier m tel que 0 < m < n.\n" +
                        "Calculez le message chiffré C avec la formule C ≡ m^e (mod n)." +
                        "");
                exmTxt.setText("Exemple de Chiffrement RSA");
                exmTxt.setTextColor(Color.parseColor("#22A39F"));
                exmN.setText("ISIMA >> 1639 1455 1639 954 2677");

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
