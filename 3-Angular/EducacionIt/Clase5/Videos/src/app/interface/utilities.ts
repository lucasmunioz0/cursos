import { NewsComponent } from './../components/news/news.component';
import { AboutComponent } from './../components/about/about.component';
import { ContactComponent } from './../components/contact/contact.component';
import { HomeComponent } from './../components/home/home.component';
import { Routes } from '@angular/router';

export const ROUTES: Routes = [
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: 'home', component: HomeComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'about', component: AboutComponent},
  {path: 'aboutus', redirectTo: 'contact'},
  {path: 'news/:id', component: NewsComponent}
];
