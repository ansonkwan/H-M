public class Monster{
    private int health;
    private int attack;
    private int speed;
    private String name;
    private int x;
    private int y;
    
    public Monster(int xpos, int ypos, String n){
        health = (int)(Math.random()*100) + 1;
        attack = (int)(Math.random()*21) + 10;
        speed = (int)(Math.random()*4);
        name = n;
        x = xpos;
        y = ypos;
    }
    
    public int getHP(){
        return health;
    }
    
    public void setHP(int HP){
        health = HP;
    }
    
    public int getATK(){
        return attack;
    }
    
    public void setATK(int ATK){
        attack = ATK;
    }
    
    public int getSPD(){
        return speed;
    }
    
    public String getName(){
        return name;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public String toString(){
        return "m";
    }
}