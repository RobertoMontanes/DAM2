import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Bulb } from './bulb';

describe('Bulb', () => {
  let component: Bulb;
  let fixture: ComponentFixture<Bulb>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Bulb]
    })
    .compileComponents();

    fixture = TestBed.createComponent(Bulb);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
