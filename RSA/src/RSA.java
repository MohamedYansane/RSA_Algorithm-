import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.SecureRandom;
@SuppressWarnings("ALL")
public class RSA {
    public static void main(String[] args) throws IOException{
        //void main conent
        SecureRandom Randomn = new SecureRandom();
        BigInteger p, q, n, phi, e, d, mes, chi, dechi;
        // Initialisation de p et q a travers  les valeurs aleatoires
        p = BigInteger.probablePrime(1024, Randomn);
        q = BigInteger.probablePrime(1024,Randomn);
        n = p.multiply(q);
        // Application de la formule phi = (p-1)(q-1)
        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        do {
            e = BigInteger.probablePrime(32,Randomn);
        }while (e.gcd(phi).intValue()!=1);
        d = e.modInverse(phi);

        BufferedReader message = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Veuillez saisir votre message: ");
        String plainText = message.readLine();
        byte[] plaintext_byte = plainText.getBytes();
        mes = new BigInteger(plaintext_byte);
        // chiffrement
        chi = mes.modPow(e,n);
        // dechiffrement
        dechi = chi.modPow(d,n);
        byte[] dechi_byte = dechi.toByteArray();
        String dechi_string = new String(dechi_byte);
        System.out.println("Paramètres");

        System.out.println("p= "+p);
        System.out.println("q= "+q);
        System.out.println("n= "+n);
        System.out.println("phi= "+phi);
        System.out.println("d= "+d);
        System.out.println("Message clair en caractère= "+plainText);
        System.out.println("Message clair en grand entier= "+mes);
        System.out.println("Message chiffré en grand entier= "+chi);
        System.out.println("Message chiffré en caractère= "+new String(chi.toByteArray()));
        System.out.println("Message déchiffré en grand entier= "+dechi);
        System.out.println("Message déchiffré en caractère= "+dechi_string);


    }
}
