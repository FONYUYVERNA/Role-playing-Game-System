//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Player player1 = new Player("Enzo",100,250);
        int attackBonus = 0;
        int defenseBonus = 0;
        int initialAttackBonus = 0;
        int initialDefenseBonus = 0;

        Scanner scanner = new Scanner(System.in);
        /*displaying attack and defense bonus of armors and weapons available*/
        System.out.println("List of armors and weapons player can equip himself with:\nWeapons: 1. Sword \n\t\t 2. Bow\nArmors: 3. Shield\n\t\t4. Helmet");

        /*Player1 equips himself with the weapons and armors chosen*/
        System.out.print("Choose desired weapon and armor: ");
        int select = Integer.parseInt(scanner.nextLine());

        while(select != 0){

            switch (select) {
                case 1:
                    Weapon weapon1 = new Sword();
                    player1.attack *= weapon1.getAttackBonus();//player's attack power with attack bonus inclusive
                   initialAttackBonus = weapon1.getAttackBonus();
                    break;
                case 2:
                    Weapon weapon2 = new Bow();
                    player1.attack *= weapon2.getAttackBonus();//player's attack power with attack bonus inclusive
                    initialAttackBonus = weapon2.getAttackBonus();
                    break;
                case 3:
                    Armor armor1 = new Shield();
                    player1.health += armor1.getDefenseBonus();//adds defense bonus of armor to health
                   initialDefenseBonus = armor1.getDefenseBonus();
                    break;
                case 4:
                    Armor armor2 = new Helmet();
                    player1.health += armor2.getDefenseBonus();//adds defense bonus of armor to health
                   initialDefenseBonus = armor2.getDefenseBonus();
                   break;

                default:
                    System.out.print("Choose desired weapon and armor: ");
                    select = Integer.parseInt(scanner.nextLine());

            }
            if (select == 1 || select == 2)
            {
                attackBonus += initialAttackBonus;
            }
            else{
                defenseBonus += initialDefenseBonus;
          }
            System.out.print("Choose desired weapon and armor: ");
            select = Integer.parseInt(scanner.nextLine());
        }



        /*Player randomly gets attacked continuously until life span is either negative of zero*/
       while (true) {
           System.out.println();

           player1.Attack();//player attacks
           player1.TakeDamage((int) (Math.random() * 101));//random attack between 0-100 on player and damage to player is computed

           player1.attack = (player1.attack * attackBonus)/8;//reduces players attack power by 10 as health of player reduces
           player1.health += defenseBonus;//adds defense bonus of armor to health

           /*ends loop when players health has completely diminished*/
           if(player1.health<=0){
               break;
           }
        }
        scanner.close();
    }
}