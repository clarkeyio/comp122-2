/**
 *
 * Constants and methods for a rotation cipher, commonly known as the Caesar
 * cipher. Known frequencies of letters are included to decipher text using the
 * chi-squared test, specifically the English language.
 *
 * @author  Ben Clarke
 *
 */
public interface RotationCipher {
    // Public static final constants

    // Known frequencies 'a' = 0 - 'z' = 25
    double[] knownFreq = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
        0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
        0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };

    // English lower case letters
    char[] lowerLetters = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    // English upper case letters
    char[] upperLetters = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };

    // Public abstract methods

    /**
     * Shifts each letter in a string by a certain amount.
     *
     * @param   s   the string to shift
     * @param   n   the amount to shift each letter by
     * @return      the shifted string
    */
    String rotate(String s, int n);

    /**
     * Deciphers a string. Makes use of the chi-squared test against known letter
     * frequencies.
     *
     * @param   s   the ciphered text to decipher
     * @return      the deciphered text
    */
    String decipher(String s);

    /**
     * Calculates the frequency of each letter in a string.
     *
     * @param   s   the string to calculate letter frequencies of
     * @return      an array of letter frequencies indexed 'a' = 0 - 'z' = 25
    */
    double[] frequencies(String s);

    /**
     * Computes chi-squared value given an array of frequencies against known frequencies.
     *
     * @param   freq    an array of frequencies
     * @return          chi-squared value
     */
    double chiSquared(double[] freq);
}
