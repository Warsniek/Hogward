package src.java.Console;

public class Wand {   // 17/03/23
    private Core core;
    private int size;

    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;

        // int randCore = (int)(Math.random()*4) + 0;
        // return core.get(randcore);
    }

    public Core getCore() {
        return core;
    }

    public void setCore(Core core) {
        this.core = core;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

