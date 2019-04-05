/**
 *
 * Prints a shifted string by a certain amount to the screen.
 *
 * @author  Ben Clarke
 * @see     Caesar
 *
 */
public class Rotate {
    /**
     * Requires two paramaters, the shift amount and the string to shift
     *
     * @param   args    an array of arguments
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            Caesar caesar = new Caesar();
            String rotated = caesar.rotate(args[1], Integer.parseInt(args[0]));
            System.out.println(rotated);
        } else if (args.length < 2) {
            System.out.println("Too few arguments!");
        } else {
            System.out.println("Too many arguments!");
        }
    }
}
