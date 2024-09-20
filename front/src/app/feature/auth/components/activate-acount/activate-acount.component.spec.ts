import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActivateAcountComponent } from './activate-acount.component';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';

describe('ActivateAcountComponent', () => {
  let component: ActivateAcountComponent;
  let fixture: ComponentFixture<ActivateAcountComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
    imports: [ActivateAcountComponent],
    providers: [
      provideHttpClient(), // Nouvelle API pour les clients HTTP
      provideHttpClientTesting(), // Nouvelle API pour les tests HTTP
    ]
});
    fixture = TestBed.createComponent(ActivateAcountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
