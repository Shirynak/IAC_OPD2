package eliaskarimi.IAC_OPD2.model;


import javax.persistence.*;

@Entity
public class Population {
    @Id
    @GeneratedValue
    private int id;
    private String population;
    private String year;
    @OneToOne(cascade = CascadeType.ALL)
    private Country country;

    public Population() {
    }

    public Population(String population, String year, Country country) {
        this.population = population;
        this.year = year;
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

