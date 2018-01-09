public class Sword{
    String name;
    int x;
    int y;
    
    public Sword(int xpos, int ypos, String n){
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
    
    public void useSword(Hero h){
        h.setATK((int)(Math.random()*21) + 30);
    }
    
    public String toString(){
            return "s";
    }
}