import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { NgxMatMenuService } from 'ngx-mat-menu';
import { BaseUrlService } from '../services/helpers/base-url.service';
import { User } from 'src/app/model/user';
import { UserService } from '../services/api/user.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(
    private http: HttpClient,
    private route: ActivatedRoute,
    private router: Router,
    private cookieService: CookieService,
    private ngxMatMenuService: NgxMatMenuService,
    private userService: UserService
    ) { 
      this.ngxMatMenuService.changeMenu(false);
    }

    user = {} as User;
    newUser = {} as User;

  username: string = '';
  password: string = '';
  cookieValue: string = '';
  isLogin: boolean = true;

  ngOnInit() {
    //sessionStorage.setItem('token', '');

    if (this.cookieService.get('user') != null) {
      //TODO
    }
  }

//   login() {
//     let url = 'http://192.168.0.50:8050/login';
//     let result = this.http.post(url, {
//         userName: this.username,
//         password: this.password
//     }).pipe(map((res: Response) => res.json())).subscribe(isValid => {
//         if (isValid) {
//             sessionStorage.setItem(
//               'token',
//               btoa(this.username + ':' + this.password)
//             );
//             this.router.navigate(['']);
//         } else {
//             alert("Authentication failed.");
//         }
//     });
// }

  login() {
    this.http.post('http://192.168.0.50:8050/user/login', {
      userName: this.username,
      password: this.password
    }).subscribe(data => {
      if (data) {
        this.cookieService.set('user', this.username, 1);
        this.cookieValue = this.cookieService.get('user');
        console.log(this.cookieValue);
      }
    });
  }
  btnChangeView() {
    console.log('btnChangeView()');
    this.isLogin = !this.isLogin;
  }

  keydownEnter() {
    if(this.user.userName && this.user.password) {
      this.login2();
    }
  }
  login2() {
    this.userService.login(this.user).subscribe(
      (data) => {
        console.log(data);
      }
    );
    this.router.navigate(['main']);
  }
  registerUser() {
    console.log('AddUser');
    this.userService.register(this.newUser).subscribe(
      (data: any) => {
        console.log(data);
      }
    );
  }
}
