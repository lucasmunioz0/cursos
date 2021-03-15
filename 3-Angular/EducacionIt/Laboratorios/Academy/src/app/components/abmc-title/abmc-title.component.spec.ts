import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AbmcTitleComponent } from './abmc-title.component';

describe('AbmcTitleComponent', () => {
  let component: AbmcTitleComponent;
  let fixture: ComponentFixture<AbmcTitleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AbmcTitleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AbmcTitleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
