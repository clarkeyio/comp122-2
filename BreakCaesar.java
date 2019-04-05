/**
 *
 * Breaks a caesar ciphered text using letter frequencies and the chi-squared test.
 *
 * @author  Ben Clarke
 * @see     Caesar
 *
 */
public class BreakCaesar {
    /**
     * Requires one paramater, the string to decipher
     *
     * @param   args    an array of arguments
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            Caesar caesar = new Caesar();
            String deciphered = caesar.decipher(args[0]);
            System.out.println(deciphered);
        } else if (args.length < 1) {
            System.out.println("Too few arguments!");
        } else {
            System.out.println("Too many arguments!");
        }
    }
}
