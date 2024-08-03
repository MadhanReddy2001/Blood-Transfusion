package cyteplasma.blood.donation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name = "donordetails")
@SequenceGenerator(name = "donordetails_id",sequenceName = "donordetails_id",allocationSize = 1919,initialValue = 98987777)
public class DonorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "donordetails_id")
    private Long Id;

    @Column(name = "donorname")
    private String donorname;

    @Column(name = "bloodgroup")
    private String bloodgroup;

    @Column(name = "mobileno")
    private String mobileno;

    @Column(name = "countryname")
    private String countryname;

    @Column(name = "statename")
    private String statename;

    @Column(name = "districtname")
    private String districtname;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "anemia")
    private String anemia;

    @Column(name = "alcohol")
    private String alcohol;

    @Column(name = "bp")
    private String bp;

    @Column(name = "diabetic")
    private String diabetic;

    @Column(name = "hiv")
    private String hiv;

    @Column(name = "medicaltreatment")
    private String medicaltreatment;

    @Column(name = "previousdonation")
    private String previousdonation;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDonorname() {
        return donorname;
    }

    public void setDonorname(String donorname) {
        this.donorname = donorname;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename;
    }

    public String getDistrictname() {
        return districtname;
    }

    public void setDistrictname(String districtname) {
        this.districtname = districtname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getAnemia() {
        return anemia;
    }

    public void setAnemia(String anemia) {
        this.anemia = anemia;
    }

    public String getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(String alcohol) {
        this.alcohol = alcohol;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getDiabetic() {
        return diabetic;
    }

    public void setDiabetic(String diabetic) {
        this.diabetic = diabetic;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getMedicaltreatment() {
        return medicaltreatment;
    }

    public void setMedicaltreatment(String medicaltreatment) {
        this.medicaltreatment = medicaltreatment;
    }

    public String getPreviousdonation() {
        return previousdonation;
    }

    public void setPreviousdonation(String previousdonation) {
        this.previousdonation = previousdonation;
    }

}
