import { Component } from '@angular/core';
import { Theme, MenuOptions } from 'ngx-mat-menu';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'webshop';

  themeSidebar: Theme;
  themeHeader: Theme;
  arrMenuOptions: MenuOptions[];
  headerText: string;
  badgeColor: any;
  loginRoute: string;
  headerIcon: string;
  logoutIcon: any;
  srcLogo: string;
  heightLogo: string = '50px';
  widthLogo: string = '50px';
  lang: string;
  visibleNotif: boolean;
  badge: number = 5;

constructor(private router: Router) {
    this.themeSidebar = {background: 'whiblte', color: 'black'};
    this.themeHeader = {background: 'blue', color: 'white'};
    this.arrMenuOptions  = [
        {id:  0, title:  'Home', icon:  null, route:  ''},
        //{id:  1, title:  'Settings', icon:  null, route:  'settings'},
    ];
    this.headerText  =  'current_user';
    this.badgeColor  =  'blue';
    this.loginRoute  =  '';
    this.headerIcon  =  'person';
    this.logoutIcon  =  undefined;
    this.srcLogo  =  './assets/webshop.png';
    this.lang  =  'en';
    this.visibleNotif  =  true;
}

openNotif(event) {
  this.badge = 0;

}

logout() {
  this.router.navigate(['']);
}
}
