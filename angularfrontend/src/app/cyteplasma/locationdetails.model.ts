export interface City {
    cities: string;
}

export interface Pincode {
    pincode: string;
    cities: string[];
}

export interface District {
    districtname: string;
    pincodes: Pincode[];
}

export interface State {
    statename: string;
    districts: District[];
}

export interface Country {
    countryname: string;
    states: State[];
}

export interface Pincodes {
    pincode: string;
}
