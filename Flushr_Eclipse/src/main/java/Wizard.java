
public class Wizard{
    private String name;
    private String spell;
    private int rank;

    
    public Wizard(String wizardName, String wizardSpell, int wizardRank){
        this.name = wizardName;
        this.spell = wizardSpell;
        this.rank = wizardRank;
    }

    public String getWizardName(){
        return this.name;
    }
    public void setWizardName(String wizardName){
        this.name = wizardName;
    }
    public String getWizardSpell(){
        return this.spell;
    }
    public void setWizardSpell(String wizardSpell){
        this.spell = wizardSpell;
    }
    public int getWizardRank(){
        return this.rank;
    }
    public void setWizardRank(int wizardRank){
        this.rank = wizardRank;
    }
}