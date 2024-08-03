import { Pipe, PipeTransform } from '@angular/core';
import { Country, Pincode } from '../locationdetails.model';

@Pipe({
  name: 'filterPincodePipe',
  standalone: true
})
export class FilterPincodePipePipe implements PipeTransform {

  transform(data:Country[],pincode:string): any {
    if(!data || !pincode){
      return null;
    }

    const filteredData = data.flatMap((country:Country)=>country.states
                              .flatMap((state)=>state.districts
                                .flatMap((district) => district.pincodes
                                .filter((pin: Pincode) => pin.pincode === pincode)
                                  .map((pin: Pincode) => ({
                                    countryname: country.countryname,
                                    statename: state.statename,
                                    districtname: district.districtname,
                                    cities: pin.cities
                                  })))));
                                  return filteredData.length ? filteredData[0] : null;
  }

}
