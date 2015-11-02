/**
 * Created by Brian on 02/11/2015.
 */
class Main {
    public static void main(String[] args){

        Inventory inventory = new Inventory(10,7,2015); //inventaire du 7 octobre 2015
        inventory.updateQuality(); // à faire tous les jours, l'inventaire gagne un jour
        inventory.Ajouter_item(new Item("nouveau nom de l'item",4,8)); // ajoute un nouvel item à vendre pendant 4 jours
        // et de qualité 8





    }



}