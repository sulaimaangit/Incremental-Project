import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Team } from 'src/models/team.model';
import { AdminService } from '../services/admin.service';
import { Player } from 'src/models/player.model';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  constructor(private adminService: AdminService) { }


  ngOnInit(): void {
  }
  @Input() teams: Team[] = [
    { name: 'aasd', maximumBudget: 1 }
  ];
  @Input() players: Player[] = [];

  @Input() editedTeam: Team | null = null;
  @Output() editTeamEvent = new EventEmitter<Team>();
  @Output() saveEditedTeamEvent = new EventEmitter<void>();
  @Output() cancelEditTeamEvent = new EventEmitter<void>();
  @Output() deleteTeamEvent = new EventEmitter<number>();
  @Output() createTeamEvent = new EventEmitter<Team>(); 

  newTeam: Team = { name: '', maximumBudget: 1 };

  editedPlayer: Player | null = null;


  get maxBidStatus(): string {
    if(this.newTeam.maximumBudget == 1){
      return "1";
    } else if (this.newTeam.maximumBudget && this.newTeam.maximumBudget < 1000) {
      return 'Too Low';
    } else if (this.newTeam.maximumBudget && this.newTeam.maximumBudget < 5000) {
      return 'Low';
    } else {
      return 'Good Budget';
    }
  }

  onEditTeam(team: Team): void {
    this.editTeamEvent.emit(team);
  }

  onSaveEditedTeam(): void {
    this.saveEditedTeamEvent.emit();
  }

  onCancelEditTeam(): void {
    this.cancelEditTeamEvent.emit();
  }

  onDeleteTeam(teamId: number): void {
    this.deleteTeamEvent.emit(teamId);
  }

  createTeam(): void {
    this.createTeamEvent.emit(this.newTeam); 
    this.newTeam = { name: '', maximumBudget: 1 }; 
  }


}
