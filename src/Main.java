//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Player player1 = new Player("Enzo",100,250);

        /*Player1 equips himself with the following weapons and armors*/
        Weapon weapon1 = new Sword();
        Armor armor1 = new Shield();

/*displaying attack and defense bonus of armors and weapons available*/
       System.out.println(weapon1.toString());
        System.out.println(armor1.toString());

        player1.attack *= weapon1.getAttackBonus();//player's attack power with attack bonus inclusive
        player1.health += armor1.getDefenseBonus();//adds defense bonus of armor to health

        /*Player randomly gets attacked continuously until life span is either negative of zero*/
        while (true) {

            System.out.println();

            player1.Attack();//player attacks
            player1.TakeDamage((int) (Math.random() * 101));//random attack between 0-100 on player and damage to player is computed

            player1.attack = (player1.attack*weapon1.getAttackBonus())/8;//reduces players attack power by 10 as health of player reduces
            player1.health += armor1.getDefenseBonus();//adds defense bonus of armor to health

            /*ends loop when players health has completely diminished*/
            if(player1.health<=0){
                break;
            }
        }
    }
}