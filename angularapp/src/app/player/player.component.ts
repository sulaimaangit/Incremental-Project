import { Component, Input, Output, EventEmitter } from '@angular/core';
import { Player } from 'src/models/player.model';
 
@Component({
  selector: 'app-player',
  templateUrl: './player.component.html',
  styleUrls: ['./player.component.css']
})
export class PlayerComponent {
  @Input() players: Player[] = [];
  @Input() editedPlayer: Player | null = null;
  @Output() editPlayerEvent = new EventEmitter<Player>();
  @Output() saveEditedPlayerEvent = new EventEmitter<void>();
  @Output() cancelEditPlayerEvent = new EventEmitter<void>();
  @Output() deletePlayerEvent = new EventEmitter<number>();
  @Output() createPlayerEvent = new EventEmitter<Player>(); 
 
  newPlayer: Player = { name: '', age: 0, category: '', biddingPrice: 0 }; 
 
 
  get biddingPriceStatus(): string {
 
    if(this.newPlayer.biddingPrice == 0){
      return "0";
    } else if (this.newPlayer.biddingPrice && this.newPlayer.biddingPrice < 1000) {
      return 'Too Low';
    } else if (this.newPlayer.biddingPrice && this.newPlayer.biddingPrice < 5000) {
      return 'Low';
    } else {
      return 'Good bidding';
    }
  }
 
  onEditPlayer(player: Player): void {
    this.editPlayerEvent.emit(player);
  }
 
  onSaveEditedPlayer(): void {
    this.saveEditedPlayerEvent.emit();
  }
 
  onCancelEditPlayer(): void {
    this.cancelEditPlayerEvent.emit();
  }
 
  onDeletePlayer(playerId: number): void {
    this.deletePlayerEvent.emit(playerId);
  }
 
  createPlayer(): void {
    this.createPlayerEvent.emit(this.newPlayer); 
    this.newPlayer = { name: '', age: 0, category: '', biddingPrice: 0 }; 
  }
}