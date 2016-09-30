/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.attacks;

import java.util.ArrayList;
import pokemon.Handler;
import pokemon.entities.creatures.Player;
import pokemon.utils.Utils;


public class AttackManager {
    
    public int atkNumber;
    private String[][] atkData;
    private Handler handler;
    private Player player;
    private ArrayList<Attack> attacks;

    public AttackManager(Handler handler) {
        this.handler = handler;
        this.player = player;
        attacks = new ArrayList<Attack>();
        loadAttacks();
        startAttacks();
    }
    
    public void loadAttacks(){
        String file = Utils.loadFileAsString("res/PokemonData/attacks.txt");
        String[] tokens = file.split("\\s+");
        atkNumber = Utils.parseInt(tokens[0]);
        atkData = new String[atkNumber][4];
        int t = 1;
        for (int i = 0; i < atkNumber; i++) {
            for (int j = 0; j < 4; j++) {
                atkData[i][j] = tokens[t];
                t++;
            }
        }
        
//        for (int i = 0; i < atkNumber; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.println(atkData[i][j]);
//            }
//        }
    
    }
    
    public void startAttacks(){
        for (int i = 0; i < atkNumber; i++) {
            addAttack(new Attack(getAtkData()[i][0],
                    Utils.parseInt(getAtkData()[i][2]),
                    Utils.parseInt(getAtkData()[i][1])));
        }
    }
    
    
    public void addAttack(Attack e){
        attacks.add(e);
    }
    
    
    //Getters and Setters

    public String[][] getAtkData() {
        return atkData;
    }

    public void setAtkData(String[][] atkData) {
        this.atkData = atkData;
    }

    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(ArrayList<Attack> attacks) {
        this.attacks = attacks;
    }
    
    
    
}
