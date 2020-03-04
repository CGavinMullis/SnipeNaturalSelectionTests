public class Environment {
    boolean safe;

    public Environment(boolean safe)
    {
        this.safe = safe;
    }

    public boolean isPlentiful()
    {
        if(this.safe)
            return true;
        else
            return false;
    }

    public boolean isDangerous()
    {
        if(this.safe)
            return false;
        else
            return true;
    }
}
