import { Team } from "./team.model";

export interface Player {
    id?:number;
    name?:string;
    age?:number;
    category?:string;
    biddingPrice?:number;
    selectedTeamId?:any;
    sold?:boolean;
    team?:Team;
}
