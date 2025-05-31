import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { PlayerComponent } from './player.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

describe('PlayerComponent', () => {
  let component: PlayerComponent;
  let fixture: ComponentFixture<PlayerComponent>;


  beforeEach(() => {

    TestBed.configureTestingModule({
      imports: [FormsModule, HttpClientModule]
    });

    fixture = TestBed.createComponent(PlayerComponent);
    component = fixture.componentInstance;
  });

  fit('Frontend_day27_should create PlayerComponent with player array', () => {
    expect(component).toBeTruthy();
    expect((component as any).players).toBeTruthy();
  });
});
