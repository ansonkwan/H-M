public class Armor{
    String name;
    int x;
    int y;
    
    public Armor(int xpos, int ypos, String n){
        name = n;
        x = xpos;
        y = ypos;
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
    
    public int useArmor(int a){
        int ATK = (int)(a*(2/3.0));
        return ATK;
    }
    
    public String toString(){
            return "a";
    }
}