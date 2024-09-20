import { TestBed } from '@angular/core/testing';

import { RegisterComponent } from './register.component';
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { AuthService } from '../../services/auth.service';
import { FormBuilder } from '@angular/forms';
import { provideHttpClient } from '@angular/common/http';

describe('RegisterComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RegisterComponent, // Importez le composant standalone ici
      ],
      providers: [
        AuthService,
        FormBuilder,
        provideHttpClient(), // Nouvelle API pour les clients HTTP
        provideHttpClientTesting(), // Nouvelle API pour les tests HTTP
      ]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(RegisterComponent);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });

});
