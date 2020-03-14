public class Snipe {
    private boolean beakIsLong;
    private boolean bodyIsFat;
    private boolean longDistanceFlier;
    private boolean conservativeGenes;

    private int age;
    private boolean isAlive;
    private int energy;

    public Snipe(boolean beak, boolean fat, boolean dist, boolean gene)
    {
        this.beakIsLong = beak;
        this.bodyIsFat = fat;
        this.longDistanceFlier = dist;
        this.conservativeGenes = gene;
        this.isAlive = true;
        this.age = 1;
        this.energy = 2;
    }

    public float GetFoodChance()
    {
        return (float) 0;
    }

    public float GetSurvivalChance()
    {
        return (float) 1;
    }



    public Snipe GenerateOffspring(Snipe other)
    {
        boolean beak;
        boolean fat;
        boolean dist;
        boolean gene;

        if(this.getConservativeGenes() && other.getConservativeGenes())
        {
            beak = other.getBeakIsLong();
            fat = other.getBodyIsFat();
            dist = other.getLongDistanceFlier();
            gene = other.getConservativeGenes();
        }
        else
        {
            beak = other.getBeakIsLong();
            fat = this.getBeakIsLong();
            dist = true;
            gene = false;
        }

        //Unparameterized Constructor
        /*Snipe babySnipe = new Snipe();
        babySnipe.setAlive(other.getAlive());
        babySnipe.setConservativeGenes(gene);
        babySnipe.setBodyIsFat(fat);
        babySnipe.setLongDistanceFlier(dist);
        babySnipe.setBeakIsLong(beak);*/

        //Parameterized Constructor
        Snipe babySnipe = new Snipe(beak, fat, dist, gene);

        babySnipe.setAlive(false);
        babySnipe.setAge(4);

        return babySnipe;
    }

    public void LoseEnergy(/*Place parameters here*/)
    {
        this.setEnergy(this.getEnergy());

        if(this.getEnergy() <= 0)
        {
            this.setAlive(false);
        }
    }

    public boolean getBeakIsLong() { return beakIsLong; }
    //public void setBeakIsLong(Boolean beakIsLong) { this.beakIsLong = beakIsLong; }

    public boolean getBodyIsFat() { return bodyIsFat; }
    //public void setBodyIsFat(Boolean bodyIsFat) { this.bodyIsFat = bodyIsFat; }

    public boolean getLongDistanceFlier() {  return longDistanceFlier;  }
    //public void setLongDistanceFlier(Boolean longDistanceFlier) { this.longDistanceFlier = longDistanceFlier; }

    public boolean getConservativeGenes() { return conservativeGenes; }
    //public void setConservativeGenes(Boolean conservativeGenes) { this.conservativeGenes = conservativeGenes; }

    public int getAge() { return this.age; }
    public void setAge(int age) { this.age = age; }

    public boolean getAlive() { return isAlive; }
    public void setAlive(Boolean alive) { isAlive = alive; }

    public int getEnergy() { return this.energy; }
    public void setEnergy(int energy) { this.energy = energy; }
}
