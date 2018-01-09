public class Potion{
    String name;
    int x;
    int y;
    
    public Potion(int xpos, int ypos, String n){
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
    
    public void usePot(Hero h){
        h.setHP(100);
    }
    
    public String toString(){
        return "p";
    }
}