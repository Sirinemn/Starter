describe('Register spec', () =>{
    it('Register successfully', () => {
        cy.visit('/auth/register');

        cy.intercept('POST', '/api/auth/register', {
            body: {
                email: 'email',
                firstName: 'firstName',
                lastName: 'lastName',
                password: 'password',
                pseudo: 'pseudo',
                dateOfBirth: 'dateOfBirth'
            },
        });
        cy.get('input[formControlName=firstname]').type("first");
        cy.get('input[formControlName=lastname]').type("last");
        cy.get('input[formControlName=pseudo]').type("pseudo");
        cy.get('input[formControlName=password]').type("password-test");
        cy.get('[formControlName="dateOfBirth"]').type('01/01/1990');
        cy.get('input[formControlName=email]').type(`${'test@mail.fr'}{enter}{enter}`);

        cy.url().should('include', '/activate-account');
    });
});