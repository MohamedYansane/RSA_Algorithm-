import static java.lang.StrictMath.pow;

@SuppressWarnings("ALL")
public class RSA_BASIC {
    static int pgcd(int a, int b)
    {
        return b == 0 ? a : pgcd(b, a%b );
    }

    public static void main(String[] args) {

        int p = 5;
        int  q = 7;
        int e = 5;
        int n = p * q;
        int fi = (p-1) * (q-1);
        while(e < fi)
        {
            if(pgcd(e,fi)==1)
                break;
            else
                e++;
        }
        int d  = 1%fi/e;
        int m = 16;
        // cryptage
        double crypte = pow(m,e);
        crypte = crypte%n;
        System.out.println(m);
        //
        double z = pow(crypte,d);
        z = m%n;
        System.out.printf("Le message envoye est: " +z);




    }
}
