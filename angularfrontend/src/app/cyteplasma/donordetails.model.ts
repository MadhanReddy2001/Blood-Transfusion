export interface DonorDetails extends Address,HealthDetails {
    donorname: string,
    bloodgroup: string,
    mobileno: string
}

export interface Address {
    countryname: string,
    statename: string,
    districtname: string,
    city: string,
    pincode: string,
}

export interface HealthDetails {
    anemia: string,
    alcohol: string,
    bp: string,
    diabetic: string,
    hiv: string,
    medicaltreatment: string,
    previousdonation: string
}
