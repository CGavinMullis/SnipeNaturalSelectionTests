public class Environment {
    boolean isPlentiful, isDangerous;

    public Environment()
    {
        this.isPlentiful = true;
        this.isDangerous = true;
    }

    public void setPlentiful(boolean plentiful) {
        this.isPlentiful = plentiful;
    }

    public void setDangerous(boolean dangerous) {
        this.isDangerous = dangerous;
    }

    public boolean getPlentiful() {
        return this.isPlentiful;
    }

    public boolean getDangerous() {
        return this.isDangerous;
    }
}
