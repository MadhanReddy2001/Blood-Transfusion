import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BloodmenuComponent } from './bloodmenu/bloodmenu.component';
import { SuccesimageComponent } from './messagecomponent/succesimage/succesimage.component';

const routes: Routes = [
  {path:'menu',component:BloodmenuComponent,
    children :[
      {
        path:'success',component:SuccesimageComponent
    }
    ]
    }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CyteplasmaRoutingModule { }
