import java.lang.Math;

/**
 *
 * Provides methods for shifting each letter in a string, and deciphering a
 * ciphered string.
 *
 * @author  Ben Clarke
 *
 */
public class Caesar implements RotationCipher {
    /**
     * Shifts each letter in a string by a certain amount.
     *
     * @param   s   the string to shift
     * @param   n   the amount to shift each letter by
     * @return      the shifted string
    */
    public String rotate(String s, int n) {
        String result = new String();
        // For each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If char is a letter, shift
            if (Character.isLetter(c)) {
                char[] letters;
                // Determine if letter is lower or upper case
                if (Character.isLowerCase(c))
                    letters = lowerLetters;
                else
                    letters = upperLetters;
                result += (char)(letters[0] + ((s.charAt(i) - letters[0] + n) % letters.length));
            } else {
                result += s.charAt(i);
            }
        }
        return result;
    }

    /**
     * Deciphers a string. Makes use of the chi-squared test against known letter
     * frequencies.
     *
     * @param   s   the ciphered text to decipher
     * @return      the deciphered text
    */
    public String decipher(String s) {
        // To decipher we will need to chi-square test each of the possible letter
        // combinations. The combination with the lowest score is the correct decryption.
        double[] chiScores = new double[lowerLetters.length];
        int min = 0;
        for (int i = 0; i < lowerLetters.length; i++) {
            // Shift the string by i
            String rotated = rotate(s, i);
            // Find the frequencies for each letter
            double[] freq = frequencies(rotated);
            // Chi-square test the frequencies
            chiScores[i] = chiSquared(freq);
            // Update the min if necessary
            if (chiScores[i] < chiScores[min])
                min = i;
        }
        // Return deciphered text
        return rotate(s, min);
    }

    /**
     * Calculates the frequency of each letter in a string.
     *
     * @param   s   the string to calculate letter frequencies of
     * @return      an array of letter frequencies indexed 'a' = 0 - 'z' = 25
    */
    public double[] frequencies(String s) {
        double[] freq = new double[lowerLetters.length];
        int[] count = new int[lowerLetters.length];
        int letterCount = 0;
        // Cycle each character and record letter count and individual occurrence
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                letterCount++;
                char[] letters;
                // Determine if letter is lower or upper case
                if (Character.isLowerCase(c))
                    letters = lowerLetters;
                else
                    letters = upperLetters;
                // Increase the count of that letter
                int letterIndex = c - letters[0];
                count[letterIndex]++;
            }
        }
        // Cycle each letter and calculate the frequency
        for (int i = 0; i < lowerLetters.length; i++) {
            freq[i] = (double)count[i] / letterCount;
        }
        return freq;
    }

    /**
     * Computes chi-squared value given an array of frequencies against known frequencies.
     *
     * @param   freq    an array of frequencies
     * @return          chi-squared value
     */
    public double chiSquared(double[] freq) {
        double chiVal = 0.0;
        // Cycle each letter and add total chi-squared value
        for (int i = 0; i < lowerLetters.length; i++) {
            chiVal += Math.pow(freq[i] - knownFreq[i], 2) / knownFreq[i];
        }
        return chiVal;
    }
}
