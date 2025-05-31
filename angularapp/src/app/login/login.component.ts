import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  
   
   username: string = '';
  password: string = '';
  role: string = '';

  constructor(private userService: UserService, private router: Router,private authService:AuthService) {}

  public login() {
    this.userService.login(this.username, this.password);
    this.authService.login(this.username,this.password,this.role);

  }


  

}
