import { Injectable } from '@angular/core';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class UserService {
    private storageKey = 'currentUser';

    constructor(private router: Router) {}
  
    register(username: string, password: string, role: string) {
      const user = { username, password, role };
      localStorage.setItem(username, JSON.stringify(user));
      this.router.navigate(['/login']);
    }
  
    login(username: string, password: string) {
      const storedUser = localStorage.getItem(username);
      if (storedUser) {
        const user = JSON.parse(storedUser);
        if (user.password === password) {
          localStorage.setItem(this.storageKey, JSON.stringify(user));
          if (user.role === 'ADMIN') {
            this.router.navigate(['/home']);
          } else if (user.role === 'ORGANIZER') {
            this.router.navigate(['/home']);
          }
        } else {
          alert('Invalid password');
        }
      } else {
        alert('User not found');
      }
    }
  
    logout() {
      localStorage.removeItem(this.storageKey);
      this.router.navigate(['/login']);
    }

    getCurrentUser() {

      const user = localStorage.getItem(this.storageKey);
      return user ? JSON.parse(user) : null;

    }
   
  
}
