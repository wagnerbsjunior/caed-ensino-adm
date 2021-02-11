import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessoresListaComponent } from './professores-lista.component';

describe('ProfessoresListaComponent', () => {
  let component: ProfessoresListaComponent;
  let fixture: ComponentFixture<ProfessoresListaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessoresListaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessoresListaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
