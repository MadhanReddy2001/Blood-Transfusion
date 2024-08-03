package cyteplasma.blood.donation.entity;
// package cyteplasma.blood.donation.model;

// import java.util.List;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.CollectionTable;
// import jakarta.persistence.Column;
// import jakarta.persistence.ElementCollection;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.SequenceGenerator;
// import jakarta.persistence.Table;

// public class LocationDetails {

//      @Entity
//      @Table(name = "country")
//      @SequenceGenerator(name = "country_id",sequenceName = "country_id",allocationSize = 1,initialValue = 1)
//      public class countries {

//       @Id
//       @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "country_id")
//       private Long Id;

//       @Column(name="countryname")
//       private String countryname;

//       @OneToMany(mappedBy = "country",cascade = CascadeType.ALL)
//         private List<States> state;

//         public countries(){

//         }

//         public countries(Long Id,String countryname, List<States> state){
//          this.Id= Id;
//          this.countryname= countryname;
//          this.state = state;
//         }

//         public Long getId() {
//             return Id;
//         }

//         public void setId(Long Id) {
//             this.Id= Id;
//         }

//         public String getCountryname() {
//             return countryname;
//         }

//         public void setCountryname (String countryname){
//             this.countryname= countryname;
//         }

//         public List<States> getStates(){
//             return state;
//         }

//         public void setStates(List<States> state) {
//             this.state= state;
//         }
//      }

//      @Entity
//      @Table(name = "state")
//      @SequenceGenerator(name= "state_id",sequenceName = "state_id",allocationSize = 1, initialValue = 1)
//      public class States {

//         @Id
//         @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "state_id")
//         private Long Id;

//         @Column(name = "statename")
//         private String statename;

//         @ManyToOne
//         @JoinColumn(name = "country_id")
//         private countries country;

//         @OneToMany(mappedBy= "state",cascade = CascadeType.ALL)
//         private List<Districts> districts;

//         public States(){
            
//         }

//         public States(String statename, countries country, List<Districts> districts) {
//             this.statename = statename;
//             this.country = country;
//             this.districts = districts;
//         }

//         public Long getId() {
//             return Id;
//         }
    
//         public void setId(Long Id) {
//             this.Id = Id;
//         }
    
//         public String getStatename() {
//             return statename;
//         }
    
//         public void setStatename(String statename) {
//             this.statename = statename;
//         }
    
//         public countries getCountry() {
//             return country;
//         }
    
//         public void setCountry(countries country) {
//             this.country = country;
//         }
    
//         public List<Districts> getDistricts() {
//             return districts;
//         }
    
//         public void setDistricts(List<Districts> districts) {
//             this.districts = districts;
//         }
//      }

//      @Entity
//      @Table(name = "district")
//      @SequenceGenerator(name= "district_id" ,sequenceName = "district_id",allocationSize = 1,initialValue = 1)
//      public class Districts {

//         @Id
//         @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "district_id")
//         private Long Id;

//         @Column(name = "districtname")
//         private String districtname;

//         @ManyToOne
//         @JoinColumn(name = "state_id")
//         private States state;

//         @OneToMany(mappedBy = "district",cascade = CascadeType.ALL)
//         private List<Pincodes> pincodes;

//         public Districts() {
//             // Default constructor
//         }
    
//         public Districts(String districtname, States state, List<Pincodes> pincodes) {
//             this.districtname = districtname;
//             this.state = state;
//             this.pincodes = pincodes;
//         }

//         public Long getId() {
//             return Id;
//         }
    
//         public void setId(Long Id) {
//             this.Id = Id;
//         }
    
//         public String getDistrictname() {
//             return districtname;
//         }
    
//         public void setDistrictname(String districtname) {
//             this.districtname = districtname;
//         }
    
//         public States getState() {
//             return state;
//         }
    
//         public void setState(States state) {
//             this.state = state;
//         }
    
//         public List<Pincodes> getPincodes() {
//             return pincodes;
//         }
    
//         public void setPincodes(List<Pincodes> pincodes) {
//             this.pincodes = pincodes;
//         }

//      }

//      @Entity
//      @Table(name = "pincode")
//      @SequenceGenerator(name = "pincode_id",sequenceName = "pincode_id",allocationSize = 1,initialValue = 1)
//      public class Pincodes {

//         @Id
//         @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pincode_id")
//         private Long Id;

//         @Column(name = "pincode")
//         private String pincode;

//         @ManyToOne
//         @JoinColumn(name = "district_id")
//         private Districts district;

//         @ElementCollection
//         @CollectionTable(name = "pincode_cities",joinColumns = @JoinColumn(name="pincode_id"))
//         @Column(name = "city")
//         private List<String> cities;

//         public Pincodes() {
//             // Default constructor
//         }
    
//         public Pincodes(String pincode, Districts district, List<String> cities) {
//             this.pincode = pincode;
//             this.district = district;
//             this.cities = cities;
//         }
        
//         public Long getId() {
//             return Id;
//         }
    
//         public void setId(Long Id) {
//             this.Id = Id;
//         }
    
//         public String getPincode() {
//             return pincode;
//         }
    
//         public void setPincode(String pincode) {
//             this.pincode = pincode;
//         }
    
//         public Districts getDistrict() {
//             return district;
//         }
    
//         public void setDistrict(Districts district) {
//             this.district = district;
//         }
    
//         public List<String> getCities() {
//             return cities;
//         }
    
//         public void setCities(List<String> cities) {
//             this.cities = cities;
//         }
//      }
// }
