const { test, expect } = require('@playwright/test');
const { HomePage } = require('../pages/HomePage');
const { LoginPage } = require('../pages/LoginPage');

test.describe('Login (POM)', () => {
    test('should open login modal when clicking Log in', async ({ page }) => {
        const home = new HomePage(page);
        await home.goto();

        const login = new LoginPage(page);
        await login.openLoginModal();

        expect(await login.isModalVisible()).toBeTruthy();
        // Check the form fields exist
        await expect(login.username).toBeVisible();
        await expect(login.password).toBeVisible();
    });
});