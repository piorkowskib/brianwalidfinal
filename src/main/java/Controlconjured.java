/**
 * Created by Brian on 02/11/2015.
 */

import java.util.Scanner;

/**
 * Created by Brian on 07/10/2015.
 */
public class Controlconjured implements Quality   {

    @Override
    public boolean isconjured(Item item) {
        System.out.print(item.getName()+ "is conjured ?\n");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str=="yes")
            return true;
        else return false;
    }
}