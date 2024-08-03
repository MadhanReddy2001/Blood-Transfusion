import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { PrimengModule } from './primeng/primeng.module';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    PrimengModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'UI';

constructor(private router:Router){}
languages = [
  { name: 'English', code: 'en' },
  { name: 'Espa�ol', code: 'es' },
  { name: 'Catalan', code: 'ca' }
];

ngAfterViewInit(){
  this.router.navigate(['cyteplasma/menu']);
  }

// initializeAppLang(): void {
//   const userLang = this.translate.getBrowserLang();
//   const lang = userLang && this.languages.find((el: any) => el.code === userLang) ? userLang : 'en';
//   this.translate.setDefaultLang(lang);
//   }
}
