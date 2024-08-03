package cyteplasma.blood.donation.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "countries")
@SequenceGenerator(name = "countries_id",sequenceName = "countries_id",allocationSize = 1,initialValue = 911000)
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "countries_id")
    private Long Id;

    @Column(name = "countryname")
    private String countryname;
    
    @OneToMany(mappedBy = "countries",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<States> states = new ArrayList<>(); 

    public Countries(){

    }

    public Countries(Long Id,String countryname){
        this.Id = Id;
        this.countryname = countryname;
    }

    public Long getId(){
        return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getCountryname(){
        return countryname;
    }

    public void setCountryname(String countryname){
    this.countryname = countryname;
    }

    public List<States> getStates(){
        return states;
    }

    public void setStates(List<States> states){
        this.states = states;
    }

    public void addComment(States comment) {
        states.add(comment);
        comment.setCountries(this);
    }
 
    public void removeComment(States comment) {
        states.remove(comment);
        comment.setCountries(null);
    }
}
