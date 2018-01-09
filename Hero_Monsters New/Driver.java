import java.io.*;
import java.util.*;

public class Driver{
    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);
        String dir = null;
        String action;
        boolean checkMap;
        boolean checkDir;
        boolean checkAction;
        boolean run;
        int kills = 0;
        Map map = new Map();

        System.out.println("** Hero & Monsters **\n");
        System.out.println("* The map has been generated *");
        System.out.println("* The enemies have been placed *");
        System.out.println("* The items have been placed *\n");
        System.out.println("Hero begins his journey in the Southwest corner of Fiona");

        while(true){
            System.out.println(map.toString(dir));
            
            do{

                System.out.print("Enter a direction (w,a,s,d): ");
                dir = reader.next();
                checkDir = checkDir(dir);

                while(checkDir == false){
                    System.out.print("Re-enter a direction (w,a,s,d): ");
                    dir = reader.next();
                    checkDir = checkDir(dir);
                }

                if(map.checkPossibleHeroPos(dir) == false){
                    System.out.println("Can not go off the map! Please try again.");
                }
            }while(map.checkPossibleHeroPos(dir) == false);
            
            if(map.isMonster(dir) != null){
                System.out.println("\nHero encounters a monster! The monster engages!");
                final int mHP = map.isMonster(dir).getHP();
                while(true){
                    System.out.print("Enter an action (run, attack): ");
                    action = reader.next();
                    checkAction = checkAction(action);
                    while(checkAction == false){
                        System.out.print("Re-enter an action (run, attack): ");
                        action = reader.next();
                        checkAction = checkAction(action);
                    }

                    run = map.run(map.isMonster(dir));

                    if(action.equals("run")){
                        if(run == false){
                            if(armorInMap(map.getMap()) == false){
                                int monsterATK = (int)(Math.random()*21) + 10;
                                map.isMonster(dir).setATK(map.getArmor().useArmor(monsterATK));
                                int heroHPS = map.getHero().getHP() - map.isMonster(dir).getATK();
                                map.getHero().setHP(heroHPS);

                                if(map.getHero().getHP() <= 0){
                                    break;
                                }else
                                    System.out.println("Monster successfully atacked the hero! Hero health is now " + heroHPS + "/100 !");
                            }else{
                                int monsterATK = (int)(Math.random()*21) + 10;
                                map.isMonster(dir).setATK(monsterATK);
                                int heroHPS = map.getHero().getHP() - map.isMonster(dir).getATK();
                                map.getHero().setHP(heroHPS);

                                if(map.getHero().getHP() <= 0){
                                    break;
                                }else
                                    System.out.println("Monster successfully atacked the hero! Hero health is now " + heroHPS + "/100 !");
                            }
                        }
                        else if(run == true){
                            if(map.getHero().getHP() <= 0){
                                break;
                            }
                            else{
                                System.out.println("The hero successfuly ran away! Hero health is " + map.getHero().getHP() + "/100 !");
                                break;
                            }
                        }
                    }
                    else if(action.equals("attack")){
                        if(swordInMap(map.getMap()) == false){
                            int monsterATK = (int)(Math.random()*21) + 10;
                            map.getSword().useSword(map.getHero());
                            map.isMonster(dir).setATK(monsterATK);
                            int monsterHPS = map.isMonster(dir).getHP() - map.getHero().getATK();
                            map.isMonster(dir).setHP(monsterHPS);

                            if(map.isMonster(dir).getHP() <= 0){
                                System.out.println("Hero has succesffuly killed the monster! Hero's health is " + map.getHero().getHP() + "/100 !");
                                map.getMap()[map.isMonster(dir).getY()][map.isMonster(dir).getX()] = " ";
                                map.move(dir);
                                kills++;
                                break;
                            }else
                                System.out.println("Hero successfully atacked the monster! Monster health is now " + monsterHPS +  "/"  + mHP +" !");

                            int heroHPS = map.getHero().getHP() - map.isMonster(dir).getATK();
                            map.getHero().setHP(heroHPS);

                            if(map.getHero().getHP() <= 0){
                                break;
                            }else{
                                System.out.println("Monster successfully atacked the hero! Hero health is now " + heroHPS + "/100 !");
                            }

                        }
                        else if(armorInMap(map.getMap()) == false){
                            int monsterATK = (int)(Math.random()*21) + 10;
                            map.isMonster(dir).setATK(map.getArmor().useArmor(monsterATK));
                            int monsterHPS = map.isMonster(dir).getHP() - map.getHero().getATK();
                            map.isMonster(dir).setHP(monsterHPS);

                            if(map.isMonster(dir).getHP() <= 0){
                                System.out.println("Hero has succesffuly killed the monster! Hero's health is " + map.getHero().getHP() + "/100 !");
                                map.getMap()[map.isMonster(dir).getY()][map.isMonster(dir).getX()] = " ";
                                map.move(dir);
                                kills++;
                                break;
                            }else
                                System.out.println("Hero successfully atacked the monster! Monster health is now " + monsterHPS +  "/"  + mHP +" !");

                            int heroHPS = map.getHero().getHP() - map.isMonster(dir).getATK();
                            map.getHero().setHP(heroHPS);

                            if(map.getHero().getHP() <= 0){
                                break;
                            }else
                                System.out.println("Monster successfully atacked the hero! Hero health is now " + heroHPS + "/100 !");
                        }    
                        else{
                            map.getHero().heroATK();
                            int monsterHP = map.isMonster(dir).getHP() - map.getHero().getATK();
                            map.isMonster(dir).setHP(monsterHP);

                            if(map.isMonster(dir).getHP() <= 0){
                                System.out.println("Hero has succesffuly killed the monster! Hero's health is " + map.getHero().getHP() + "/100 !");
                                map.getMap()[map.isMonster(dir).getY()][map.isMonster(dir).getX()] = " ";
                                map.move(dir);
                                kills++;
                                break;
                            }else
                                System.out.println("Hero successfully atacked the monster! Monster health is now " + monsterHP +  "/"  + mHP +" !");

                            int heroHP = map.getHero().getHP() - map.isMonster(dir).getATK();
                            map.getHero().setHP(heroHP);

                            if(map.getHero().getHP() <= 0){
                                break;
                            }else
                                System.out.println("Monster successfully atacked the hero! Hero health is now " + heroHP + "/100 !");

                        }
                    }
                }

            }
            else if(map.isPotion(dir) != null){
                System.out.println("\nHero finds max potion! Hero's health goes up to 100!");
                map.isPotion(dir).usePot(map.getHero());
                map.getMap()[map.isPotion(dir).getY()][map.isPotion(dir).getX()] = " ";
                map.move(dir);
            }
            else if(map.isSword(dir) != null){
                if(kills < 4){
                    System.out.println("\nMy family is gone and I have nothing left except for a broad sword I have buried. " +
                    "Only a true hero will receive this.");
                    System.out.println("Quest Requirement: Kill 4 monsters.");
                    int complete = (int)((kills/4.0)*100);
                    System.out.println("Quest Complition: " + complete + "%");
                }
                else if(kills >= 4){
                    System.out.println("\nMy family is gone and I have nothing left except for a broad sword I have buried. " +
                    "Only a true hero will receive this.");
                    System.out.println("Quest Requirement: Kill 4 monsters.");
                    int complete = (int)((kills/4.0)*100);
                    System.out.println("Quest Complition: " + complete + "%");
                    System.out.println("\nHero recieves a sword! Hero's attack increases to 30-50 hit points!");
                    map.isSword(dir).useSword(map.getHero());
                    map.getMap()[map.isSword(dir).getY()][map.isSword(dir).getX()] = " ";
                    map.move(dir);
                }
            }
            else if(map.isArmor(dir) != null){
                if(kills < 2){
                    System.out.println("\nMy sheep have been taken and I have nothing left except for bronze armor I have buried. " +
                    "Only a true hero will receive this.");
                    System.out.println("Quest Requirement: Kill 2 monsters.");
                    int complete = (int)((kills/2.0)*100);
                    System.out.println("Quest Complition: " + complete + "%");
                }
                else if(kills >= 2){
                    System.out.println("\nMy sheep have been taken and I have nothing left except for bronze armor I have buried. " +
                    "Only a true hero will receive this.");
                    System.out.println("Quest Requirement: Kill 2 monsters.");
                    int complete = (int)((kills/2.0)*100);
                    System.out.println("Quest Complition: " + complete + "%");
                    System.out.println("\nHero recieves bronze armor! Hero's defense goes up by 1/3!");
                    map.getMap()[map.isArmor(dir).getY()][map.isArmor(dir).getX()] = " ";
                    map.move(dir);
                }
            }else
                map.move(dir);

            checkMap =  emptyMap(map.getMap());

            if(map.getHero().getHP() <= 0){
                System.out.println("\n* Hero is struck with a deadly blow by a Monster and collapses *");
                System.out.println("** Monsters in the surrounding area converge on the carcass. **");
                break;
            }else if(emptyMap(map.getMap()) == true){
                System.out.println("\n* Hero has cleansed the land of all the evil! *");
                System.out.println("** The land returns to peace. **");
                break;
            }
        }

    }

    public static boolean checkDir(String dir){
        String[] possibleDir = {"w","a","s","d"};

        for(String d : possibleDir){
            if(d.equals(dir)){
                return true;
            }
        }

        return false;
    }

    public static boolean checkAction(String action){
        String[] possibleAction = {"run","attack"};

        for(String a : possibleAction){
            if(a.equals(action)){
                return true;
            }
        }

        return false;
    }

    public static boolean emptyMap(Object map[][]){
        boolean check = true;

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] instanceof String || map[i][j] instanceof Hero || map[i][j] instanceof Potion || map[i][j] instanceof Sword || map[i][j] instanceof Armor){
                    check = check && true;
                }else
                    check = check && false;
            }
        }

        return check;
    }

    public static boolean swordInMap(Object map[][]){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] instanceof Sword){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean armorInMap(Object map[][]){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] instanceof Armor){
                    return true;
                }
            }
        }

        return false;
    }
}