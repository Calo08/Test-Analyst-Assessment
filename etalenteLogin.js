const { I } = inject();

Feature('eTalente Login');

Scenario('Successful Login', async () => {
    I.amOnPage('https://etalente.co.za');
    I.fillField('username', 'validUsername');
    I.fillField('password', 'validPassword');
    I.click('Login');
    I.see('Welcome, validUsername!');
});

Scenario('Failed Login', async () => {
    I.amOnPage('https://etalente.co.za');
    I.fillField('username', 'invalidUsername');
    I.fillField('password', 'invalidPassword');
    I.click('Login');
    I.see('Invalid username or password');
});