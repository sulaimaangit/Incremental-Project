import { Component, OnInit } from '@angular/core';
import { Player } from 'src/models/player.model';
import { Team } from 'src/models/team.model';
import { OrganizerService } from '../services/organizer.service';
import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-organizer',
  templateUrl: './organizer.component.html',
  styleUrls: ['./organizer.component.css']
})
export class OrganizerComponent implements OnInit {

    teams:Team[]=[];
    players:Player[];
    unsoldPlayers:Player[];
    playersByCategory:Player[];
    playersOfTeamId:Player[];
    showPlayerButtonClicked:boolean=false;
    releasedButtonclicked:boolean=false;
    count=1;
    selectedCategory : any;
    selectedTeam : Team;
    displayTeamId : number;
    displayTeamName : string = "";

    categories:string[]=['All','Batsman','Batswomen','Bowler','Wicket Keeper','Fielder'];

  constructor(private service:OrganizerService,private authService:AuthService) { }

  ngOnInit(): void {
    this.getAllTeams();
    //console.log(this.teams);
  }

   public getAllTeams(){
    return this.service.getAllTeams().subscribe(data=>this.teams=data);
  }
   public getUnsoldPlayers(){
      return this.service.getUnsoldPlayers().subscribe(data=>this.unsoldPlayers=data);
   }
   public filterPlayersByCategory(category:string){
    this.selectedCategory = category;
     return this.service.getPlayersByCategory(category).subscribe(data=>{
        this.playersByCategory=data
        this.playersByCategory =  this.playersByCategory.filter(el=>el.sold == false);
        console.log(this.playersByCategory);
     });
   }

   public assignPlayerToTeamId(teamId:number,player:Player){

    return this.service.assignPlayerToTeam(teamId,player).subscribe((data)=>{
        this.getAllTeams();console.log("hiiii"+teamId);
        this.filterPlayersByCategory(this.selectedCategory);
    });
   }
   public releasePlayerById(playerId:number){
     this.releasedButtonclicked=!this.releasedButtonclicked;
     return this.service.releasePlayerFromTeam(playerId).subscribe(data=>{
        this.filterPlayersByCategory(this.selectedCategory);
        this.getAllPlayersByTeamId(this.displayTeamId,this.displayTeamName);
    });
   }
  
   public getAllPlayersByTeamId(teamId:number,teamName : string){
    this.showPlayerButtonClicked=!this.showPlayerButtonClicked;
    this.displayTeamName = teamName;
    this.displayTeamId = teamId;
    return this.service.getPlayerByTeamId(teamId).subscribe(data=>{
        this.playersOfTeamId=(data as Player[]);
    });
   }

    public logout(){
    this.authService.logout();
 }
  

}
