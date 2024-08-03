import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path:'cyteplasma',loadChildren:()=>import('./cyteplasma/cyteplasma.module').then(m=>m.CyteplasmaModule)
    }
];
