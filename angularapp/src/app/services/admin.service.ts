import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Team } from 'src/models/team.model';
import { Player } from 'src/models/player.model';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

    public baseUrl="https://ide-bcefcbccbedfab314820188eabbabbffour.premiumproject.examly.io/proxy/8080/"

  constructor(private httpClient:HttpClient) { }

  public getTeams():Observable<Team[]>{
    return this.httpClient.get<Team[]>(this.baseUrl+'/api/team');
  }

  public createTeam(team:Team):Observable<any>{
    return this.httpClient.post(this.baseUrl+"/api/team",team);
  }

  public updateTeam(teamId:number, team:Team):Observable<any>{
    return this.httpClient.put(this.baseUrl+"/api/team/"+teamId,team);
  }

  public deleteTeam(teamId:number):Observable<any>{
    return this.httpClient.delete(this.baseUrl+"/api/team/"+teamId);
  }

  public getPlayers():Observable<any>{
    return this.httpClient.get(this.baseUrl+"/api/player");
  }

  public createPlayer(player:Player):Observable<any>{
    return this.httpClient.post(this.baseUrl+"/api/player",player);
  }

  public updatePlayer(playerId:number, player:Player):Observable<any>{
    return this.httpClient.put(this.baseUrl+"/api/player/"+playerId,player);
  }

  public deletePlayer(playerId:number):Observable<any>{
    return this.httpClient.delete(this.baseUrl+"/api/player/"+playerId);
  }

}
