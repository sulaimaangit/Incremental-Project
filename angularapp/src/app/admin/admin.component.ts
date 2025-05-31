import { Component, OnInit } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { Team } from '../../models/team.model';
import { Player } from '../../models/player.model';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  teams: Team[] = [];
  players: Player[] = [

  ];

  newTeam: Team = { name: '', maximumBudget: 1 };
  newPlayer: Player = { name: '', age: 0, category: '',biddingPrice:0};

  editedTeam: Team | null = null;
  editedPlayer: Player | null = null;


  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.getTeams();
    this.getPlayers();
  }

  getTeams(): void {
    this.adminService.getTeams().subscribe((teams) => {
      this.teams = teams;
    });
  }

  createTeam(newTeam:Team): void {

    this.adminService.createTeam(newTeam).subscribe(() => {
      console.log("teamofnew"+newTeam);

      this.getTeams();
    });
  }

  editTeam(team: Team): void {
    this.editedTeam = { ...team };

  }
  saveEditedTeam(): void {
    if (this.editedTeam) {
      this.adminService.updateTeam(this.editedTeam.id, this.editedTeam).subscribe(() => {
        this.getTeams();
        this.editedTeam = null;
      });
    }
  }

  cancelEditTeam(): void {
    this.editedTeam = null;
  }

  deleteTeam(teamId: number): void {
    this.adminService.deleteTeam(teamId).subscribe(() => {
      this.getTeams();
    });
  }

  getPlayers(): void {
    this.adminService.getPlayers().subscribe((players) => {
      this.players = players;
    });
  }

  createPlayer(newPlayer: Player): void {
    console.log(newPlayer);
    this.adminService.createPlayer(newPlayer).subscribe(() => {
      this.getPlayers();
    });
  }

  editPlayer(player: Player): void {
    this.editedPlayer = { ...player };

  }
  saveEditedPlayer(): void {
    if (this.editedPlayer) {
      this.adminService.updatePlayer(this.editedPlayer.id, this.editedPlayer).subscribe(() => {
        this.getPlayers();
        this.editedPlayer = null;
      });
    }
  }

  cancelEditPlayer(): void {
    this.editedPlayer = null;
  }

  deletePlayer(playerId: number): void {
    this.adminService.deletePlayer(playerId).subscribe(() => {
      this.getPlayers();
    });
  }
}
