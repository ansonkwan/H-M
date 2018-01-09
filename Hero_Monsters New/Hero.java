public class Hero{
    private int health;
    private int attack;
    private String name;
    private int x;
    private int y;
    
    public Hero(int xpos, int ypos){
        health = 100;
        attack = (int)(Math.random()*21) + 10;
        name = "Hero";
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
    
    public void heroATK(){
        attack = (int)(Math.random()*21) + 10;
    }
    
    public void setATK(int ATK){
        attack = ATK;
    }
    
    public String getName(){
        return name;
    }
    
    public int getX(){
        return x;
    }
    
    public void setX(int xpos){
        x = xpos;
    }
    
    public int getY(){
        return y;
    }
    
    public void setY(int ypos){
        y = ypos;
    }
    
    public String toString(){
        return "h";
    }
}