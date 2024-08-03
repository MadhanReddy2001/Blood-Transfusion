package cyteplasma.blood.donation.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "states")
@SequenceGenerator(name = "states_id",sequenceName = "states_id",allocationSize = 1,initialValue = 200000)
public class States {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "states_id")
    private Long Id;

    @Column(name = "statename")
    private String statename;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countries_id")
    private Countries countries;

    @OneToMany(mappedBy = "states",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Districts> districts = new ArrayList<>(); 

    public States(){

    }

    public States(Long Id,String statename){
        this.Id = Id;
        this.statename = statename;
    }
    
    public Long getId(){
        return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getStatename(){
        return statename;
    }

    public void setStatename(String statename){
        this.statename = statename;
    }

    public Countries getCountries(){
        return countries;
    }

    public void setCountries(Countries countries){
        this.countries= countries;
    }

    public List<Districts> getDistricts(){
        return districts;
    }

    public void setDistricts(List<Districts> districts){
        this.districts = districts;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
            
        if (!(o instanceof States))
            return false;
            
        return
            Id != null &&
            Id.equals(((States) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    public void addComment(Districts comment) {
        districts.add(comment);
        comment.setStates(this);
    }
 
    public void removeComment(Districts comment) {
        districts.remove(comment);
        comment.setStates(null);
    }
}
