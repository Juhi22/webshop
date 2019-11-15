import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

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
    private cookieService: CookieService) { }

  username: string = '';
  password: string = '';
  cookieValue: string = '';

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

}
