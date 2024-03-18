import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;
/*This class represents a player character in the game*/
public class Player {
    private String name;//represents players name
     int health;//represents player's health points
    int attack;//represents player's base attack power

    Player(String name, int health, int attack){
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

            void Attack(){
     System.out.println(this.name + "'s current attack power is " + this.attack);
    }//outputs player's attack with current attack power

    void TakeDamage(int damage) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        health-=damage;
        if(health<=0){
            System.out.println(this.name + "'s current health is " + health);
            System.out.println(name + " died in action");
            System.out.println("GAME OVER!");
            Scanner scanner = new Scanner(System.in);
            File file = new File("Game Over sound effect.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.start();
            System.out.println("\nEnter 'q' to quit the game:");
            String response = scanner.next();
            if(response.equalsIgnoreCase("q")) {
                clip.stop();
            }
        }
        else {
            System.out.println(this.name + "'s current health is " + health);
        }
    }//reduce the player's health pts by a specific amount when attacked
}
