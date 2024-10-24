import { Component, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';
import { User } from '../../../interface/user';
import { SessionService } from '../../../service/session.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [MatButtonModule, MatIconModule, NgIf],
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.scss'
})
export class WelcomeComponent implements OnInit{


  public user!: User;

  constructor(private sessionService: SessionService, private router: Router){}

  ngOnInit() {
    this.user = this.sessionService.user!;
    console.log(this.user);
  }

  logOut() {
    this.sessionService.logOut();
    this.router.navigate(['']);
  }

}
