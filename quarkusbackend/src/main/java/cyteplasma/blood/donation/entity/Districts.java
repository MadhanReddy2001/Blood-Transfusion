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
@Table(name = "districts")
@SequenceGenerator(name = "districts_id",sequenceName = "districts_id",allocationSize = 1,initialValue = 242526)
public class Districts {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "districts_id")
    private Long Id;

    @Column(name = "districtname")
    private String districtname;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "states_id")
    private States states;

    @OneToMany(mappedBy = "districts",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Pincodes> pincodes = new ArrayList<>(); 

    public Long getId(){
     return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getDistrictname(){
        return districtname;
    }

    public void setDistrictname(String districtname){
        this.districtname = districtname;
    }

    public States getStates(){
        return states;
    }

    public void setStates(States states){
        this.states = states;
    }

    public List<Pincodes> getPincodes(){
        return pincodes;
    }

    public void setPincodes(List<Pincodes> pincodes){
        this.pincodes = pincodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
            
        if (!(o instanceof Districts))
            return false;
            
        return
            Id != null &&
            Id.equals(((Districts) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


    public void addComment(Pincodes comment) {
        pincodes.add(comment);
        comment.setDistricts(this);
    }
 
    public void removeComment(Pincodes comment) {
        pincodes.remove(comment);
        comment.setDistricts(null);
    }
}
