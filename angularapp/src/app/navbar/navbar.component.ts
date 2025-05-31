import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {


  role: string | null = null;

  constructor(private userService: UserService) {}

  ngOnInit() {
    const currentUser = this.userService.getCurrentUser();
    this.role = currentUser ? currentUser.role : null;
  }

  logout() {
    this.userService.logout();
  }


}
