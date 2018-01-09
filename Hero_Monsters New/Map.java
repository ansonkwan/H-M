public class Map{
    private Object[][] map = new Object[10][10];
    private Hero hero;
    private Monster m1,m2,m3,m4,m5,m6;
    private Potion pot1,pot2;
    private Sword sword;
    private Armor armor;
    private Monster[] monsters = {m1,m2,m3,m4,m5,m6};
    private static int invisA;
    private static int invisS;
    
    public Map(){
        boolean setpos;
        int x;
        int y;

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = " ";
            }
        }

        hero = new Hero(0,map.length - 1);
        map[hero.getY()][hero.getX()] = hero;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        pot1 = new Potion(x,y,"Pot1");
        map[pot1.getY()][pot1.getX()] = pot1;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        pot2 = new Potion(x,y,"Pot2");
        map[pot2.getY()][pot2.getX()] = pot2;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        sword = new Sword(x,y,"Sword");
        map[sword.getY()][sword.getX()] = sword;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        armor = new Armor(x,y,"Armor");
        map[armor.getY()][armor.getX()] = armor;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        m1 = new Monster(x,y,"M1");
        map[m1.getY()][m1.getX()] = m1;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        m2 = new Monster(x,y,"M2");
        map[m2.getY()][m2.getX()] = m2;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        m3 = new Monster(x,y,"M3");
        map[m3.getY()][m3.getX()] = m3;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        m4 = new Monster(x,y,"M4");
        map[m4.getY()][m4.getX()] = m4;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        m5 = new Monster(x,y,"M5");
        map[m5.getY()][m5.getX()] = m5;

        do{
            x = (int)(Math.random()*10);
            y = (int)(Math.random()*10);
            setpos = checkPos(x,y);
        }while(setpos == false);
        m6 = new Monster(x,y,"M6");
        map[m6.getY()][m6.getX()] = m6;
    }

    public Hero getHero(){
        return hero;
    }

    public Object[][] getMap(){
        return map;
    }

    public Sword getSword(){
        return sword;
    }

    public Armor getArmor(){
        return armor;
    }

    public boolean checkPos(int x, int y){
        if(map[y][x] instanceof String){
            return true;
        }else
            return false;
    }

    public String toString(String direction){
        String format = "";
        for(Object[] row : map){
            for(Object colum : row){
                if(colum instanceof Armor){
                    format = format + colum.toString() + " ";
                }
                else if(colum instanceof Sword){
                    format = format + colum.toString() + " ";
                }
                else if(colum instanceof Monster){
                    format = format + colum.toString() + " ";
                }
                else if(colum instanceof Potion){
                    format = format + colum.toString() + " ";
                }
                else if(colum instanceof Hero){
                    format = format + colum.toString() + " ";
                }
                else if(colum instanceof String){
                    format = format + " " + " ";
                }
            }
            format = format + "\n";
        }

        return format;
    }

    public boolean checkPossibleHeroPos(String direction){
        if(direction.equals("s")){
            if(((hero.getY() + 1) < 10 && hero.getY() >= 0) && (hero.getX() < 10 && hero.getX() >= 0)){
                return true;
            }
        }else if(direction.equals("w")){
            if((hero.getY() < 10 && (hero.getY() - 1) >= 0) && (hero.getX() < 10 && hero.getX() >= 0)){
                return true;
            }
        }else if(direction.equals("d")){
            if((hero.getY() < 10 && hero.getY() >= 0) && ((hero.getX() + 1) < 10 && hero.getX() >= 0)){
                return true;
            }
        }else if(direction.equals("a")){
            if((hero.getY() < 10 && hero.getY() >= 0) && (hero.getX() < 10 && (hero.getX() - 1) >= 0)){
                return true;
            }
        }

        return false;  
    }

    public void move(String direction){
        if(direction.equals("s")){
            hero.setY(hero.getY() + 1);
            map[hero.getY()][hero.getX()] = hero;
            map[hero.getY() - 1][hero.getX()] = " ";
        }else if(direction.equals("w")){
            hero.setY(hero.getY() - 1);
            map[hero.getY()][hero.getX()] = hero;
            map[hero.getY() + 1][hero.getX()] = " ";
        }else if(direction.equals("d")){
            hero.setX(hero.getX() + 1);
            map[hero.getY()][hero.getX()] = hero;
            map[hero.getY()][hero.getX() - 1] = " ";
        }else if(direction.equals("a")){
            hero.setX(hero.getX() - 1);
            map[hero.getY()][hero.getX()] = hero;
            map[hero.getY()][hero.getX() + 1] = " ";
        }
    }

    public Monster isMonster(String direction){
        Monster[] monsters = {m1,m2,m3,m4,m5,m6};
        for(Monster m : monsters){
            if(direction.equals("w")){
                if(((hero.getY() - 1) == m.getY()) && (hero.getX() == m.getX()) && map[m.getY()][m.getX()] instanceof Monster){
                    return m;
                }
            }else if(direction.equals("s")){
                if(((hero.getY() + 1) == m.getY()) && (hero.getX() == m.getX()) && map[m.getY()][m.getX()] instanceof Monster){
                    return m;
                }
            }else if(direction.equals("d")){
                if((hero.getY() == m.getY()) && ((hero.getX() + 1) == m.getX()) && map[m.getY()][m.getX()] instanceof Monster){
                    return m;
                }
            }else if(direction.equals("a")){
                if((hero.getY() == m.getY()) && ((hero.getX() - 1) == m.getX()) && map[m.getY()][m.getX()] instanceof Monster){
                    return m;
                }
            }
        }

        return null;
    }

    public Potion isPotion(String direction ){       
        if(direction.equals("w")){
            if(((hero.getY() - 1) == pot1.getY()) && (hero.getX() == pot1.getX()) && map[pot1.getY()][pot1.getX()] instanceof Potion){
                return pot1;
            }
        }else if(direction.equals("s")){
            if(((hero.getY() + 1) == pot1.getY()) && (hero.getX() == pot1.getX()) && map[pot1.getY()][pot1.getX()] instanceof Potion){
                return pot1;
            }
        }else if(direction.equals("d")){
            if((hero.getY() == pot1.getY()) && ((hero.getX() + 1) == pot1.getX()) && map[pot1.getY()][pot1.getX()] instanceof Potion){
                return pot1;
            }
        }else if(direction.equals("a")){
            if((hero.getY() == pot1.getY()) && ((hero.getX() - 1) == pot1.getX()) && map[pot1.getY()][pot1.getX()] instanceof Potion){
                return pot1;
            }
        }

        if(direction.equals("w")){
            if(((hero.getY() - 1) == pot2.getY()) && (hero.getX() == pot2.getX()) && map[pot2.getY()][pot2.getX()] instanceof Potion){
                return pot2;
            }
        }else if(direction.equals("s")){
            if(((hero.getY() + 1) == pot2.getY()) && (hero.getX() == pot2.getX()) && map[pot2.getY()][pot2.getX()] instanceof Potion){
                return pot2;
            }
        }else if(direction.equals("d")){
            if((hero.getY() == pot2.getY()) && ((hero.getX() + 1) == pot2.getX()) && map[pot2.getY()][pot2.getX()] instanceof Potion){
                return pot2;
            }
        }else if(direction.equals("a")){
            if((hero.getY() == pot2.getY()) && ((hero.getX() - 1) == pot2.getX()) && map[pot2.getY()][pot2.getX()] instanceof Potion){
                return pot2;
            }
        }

        return null;
    }

    public Sword isSword(String direction){
        if(direction.equals("w")){
            if(((hero.getY() - 1) == sword.getY()) && (hero.getX() == sword.getX()) && map[sword.getY()][sword.getX()] instanceof Sword){
                return sword;
            }
        }else if(direction.equals("s")){
            if(((hero.getY() + 1) == sword.getY()) && (hero.getX() == sword.getX()) && map[sword.getY()][sword.getX()] instanceof Sword){
                return sword;
            }
        }else if(direction.equals("d")){
            if((hero.getY() == sword.getY()) && ((hero.getX() + 1) == sword.getX()) && map[sword.getY()][sword.getX()] instanceof Sword){
                return sword;
            }
        }else if(direction.equals("a")){
            if((hero.getY() == sword.getY()) && ((hero.getX() - 1) == sword.getX()) && map[sword.getY()][sword.getX()] instanceof Sword){
                return sword;
            }
        }

        return null;
    }

    public Armor isArmor(String direction){
        if(direction.equals("w")){
            if(((hero.getY() - 1) == armor.getY()) && (hero.getX() == armor.getX()) && map[armor.getY()][armor.getX()] instanceof Armor){
                return armor;
            }
        }else if(direction.equals("s")){
            if(((hero.getY() + 1) == armor.getY()) && (hero.getX() == armor.getX()) && map[armor.getY()][armor.getX()] instanceof Armor){
                return armor;
            }
        }else if(direction.equals("d")){
            if((hero.getY() == armor.getY()) && ((hero.getX() + 1) == armor.getX()) && map[armor.getY()][armor.getX()] instanceof Armor){
                return armor;
            }
        }else if(direction.equals("a")){
            if((hero.getY() == armor.getY()) && ((hero.getX() - 1) == armor.getX()) && map[armor.getY()][armor.getX()] instanceof Armor){
                return armor;
            }
        }

        return null;
    }

    public boolean run(Monster m){
        int probability = (int)(Math.random()*101);
        if(m.getSPD() == 0){
            if(probability <= 75){
                return true;
            }else
                return false;
        }
        else if(m.getSPD() == 1){
            if(probability <= 50){
                return true;
            }else
                return false;
        }
        else if(m.getSPD() == 2){
            if(probability <= 25){
                return true;
            }else
                return false;
        }
        else
            return false;
    }
}