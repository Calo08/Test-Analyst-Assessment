import { Selector } from 'testcafe';

fixture('eTalente Login');

test('Successful Login', async t => {
    await t.navigateTo('https://etalente.co.za');
    await t.typeText(Selector('input[name="username"]'), 'validUsername');
    await t.typeText(Selector('input[name="password"]'), 'validPassword');
    await t.click(Selector('button[type="submit"]'));
    await t.expect(Selector('div.welcome-message').textContent).eql('Welcome, validUsername!');
});

test('Failed Login', async t => {
    await t.navigateTo('https://etalente.co.za');
    await t.typeText(Selector('input[name="username"]'), 'invalidUsername');
    await t.typeText(Selector('input[name="password"]'), 'invalidPassword');
    await t.click(Selector('button[type="submit"]'));
    await t.expect(Selector('div.error-message').textContent).eql('Invalid username or password');
});