package japan;

public class Secundant {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Secundant() {
    }

    public Secundant(String name) {
        this.name = name;
    }

    public void chopHead(){
        System.out.println("Secundant "+ getName() + " chopped samurai`s head off");
    }

}
