/**
 * Created by Brian on 02/11/2015.
 */

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Inventory {

    private Item[] items;

    private int day;
    private int month;
    private int year;

    boolean conjured;

    public Inventory(Item[] items) {
        super();
        this.items = items;
    }

    public Inventory(int month, int day, int year) {
        super();
        items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
        };
        this.day=day;
        this.month=month;
        this.year=year;


    }


    public Item[] GetItem(){
        return this.items;
    }
    public void SetItem(Item item){
        this.items[this.items.length-1]=item;
    }

    public Inventory Ajouter_item(Item it){
        this.SetItem(it);
        return this;
    }




    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Controlconjured control=new Controlconjured();
            this.conjured=control.isconjured(items[i]);
            if (items[i].getName() != "Aged Brie"
                    && items[i].getName() != "Backstage passes to a TAFKAL80ETC concert"
                    && items[i].getQuality() > 0
                    && items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                items[i].setQuality(items[i].getQuality() - 1);
                if(this.conjured)
                    items[i].setQuality(items[i].getQuality() - 1);




            }

            else {

                if (items[i].getQuality() < 50) {
                    items[i].setQuality(items[i].getQuality() + 1);

                    if (items[i].getName() == "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].getSellIn() < 11) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }

                        if (items[i].getSellIn() < 6) {
                            if (items[i].getQuality() < 50) {
                                items[i].setQuality(items[i].getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                items[i].setSellIn(items[i].getSellIn() - 1);
                if (this.day<=30)
                    this.day += 1;
                else if(this.month <=11)
                    this.month +=1;
                else  this.year+=1;


            }

            if (items[i].getSellIn() < 0) {
                if (items[i].getName() != "Aged Brie") {
                    if (items[i].getName() != "Backstage passes to a TAFKAL80ETC concert") {
                        if (items[i].getQuality() > 0) {
                            if (items[i].getName() != "Sulfuras, Hand of Ragnaros") {
                                items[i].setQuality(items[i].getQuality() - 1);
                                if(this.conjured)
                                    items[i].setQuality(items[i].getQuality() - 1);




                            }
                        }
                    }

                    else {
                        items[i].setQuality(items[i].getQuality() - items[i].getQuality());
                    }
                }

                else {

                    if (items[i].getQuality() < 50) {
                        items[i].setQuality(items[i].getQuality() + 1);
                    }
                }
            }
        }
    }
}