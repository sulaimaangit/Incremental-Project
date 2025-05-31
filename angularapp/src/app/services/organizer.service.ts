import { Injectable } from '@angular/core';
import { Player } from 'src/models/player.model';
import { HttpClient } from '@angular/common/http';
import { Team } from 'src/models/team.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrganizerService {

  backendUrl="https://ide-bcefcbccbedfab314820188eabbabbffour.premiumproject.examly.io/proxy/8080/";

  constructor(private httpClient:HttpClient) { }

  public getUnsoldPlayers():Observable<any>{
    return this.httpClient.get(this.backendUrl+"/api/organizer/unsold-players"); 
  }
  public getPlayersByCategory(category:string):Observable<any>{
    return this.httpClient.get(this.backendUrl+"/api/organizer/player-list/category/"+category);
  }
  public assignPlayerToTeam(teamId:number,player:Player):Observable<any>{
    console.log(teamId);
    return this.httpClient.post(this.backendUrl+"/api/organizer/assign-player/"+teamId+"/"+player.id,"");                                        
  }
  public releasePlayerFromTeam(playerId:number):Observable<any>{
   return this.httpClient.put(this.backendUrl+"/api/organizer/release-player/"+playerId,"");
  } 
  public getAllTeams():Observable<any>{
   return this.httpClient.get(this.backendUrl+"/api/organizer/team-list");
  }
  public getPlayerByTeamId(teamId:number):Observable<any>{
    return this.httpClient.get(this.backendUrl+"/api/organizer/player-list/"+teamId);
  }
}
