package cyteplasma.blood.donation.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "pincodes")
@SequenceGenerator(name = "pincodes_id",sequenceName = "pincodes_id",allocationSize = 1,initialValue = 988675)
public class Pincodes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pincodes_id")
    private Long Id;
    
    @Column(name = "pincode")
    private String pincode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "districts_id")
    private Districts districts;

     @ElementCollection(fetch = FetchType.EAGER)
     @CollectionTable(name = "pincode_cities",joinColumns = @JoinColumn(name="pincode_id"))
     @Column(name = "city")
     private List<String> cities;

    public Long getId(){
        return Id;
    }

    public void setId(Long Id){
        this.Id = Id;
    }

    public String getPincode(){
        return pincode;
    }

    public void setPincode(String pincode){
        this.pincode = pincode;
    }

    public Districts getDistricts(){
        return districts;
    }

    public void setDistricts(Districts districts){
        this.districts = districts;
    }

    public List<String> getCities() {
                    return cities;
                }

    public void setCities(List<String> cities) {
                    this.cities = cities;
                }
                
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
            
        if (!(o instanceof Pincodes))
            return false;
            
        return
            Id != null &&
            Id.equals(((Pincodes) o).getId());
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
