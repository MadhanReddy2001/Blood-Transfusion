import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';

import { provideHttpClient } from '@angular/common/http';
import { provideClientHydration } from '@angular/platform-browser';
import { provideAnimations } from '@angular/platform-browser/animations';
import { routes } from './app.routes';

// export function initializeAppFactory(appComponent: AppComponent): () => void {
//   return () => appComponent.initializeAppLang();
// }

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideClientHydration(),
    provideHttpClient(),
    provideAnimations(),
    // {
    //   provide: TranslateLoader,
    //   useFactory: HttpLoaderFactory,
    //   deps: [HttpClient]
    // },
    // {
    //   provide: APP_INITIALIZER,
    //   useFactory: initializeAppFactory,
    //   deps: [AppComponent],
    //   multi: true
    // }
  ]
};
