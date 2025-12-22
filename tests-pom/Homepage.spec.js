const { test, expect } = require('@playwright/test');
const { HomePage } = require('../pages/HomePage');

test.describe('Homepage (POM)', () => {
    test('should list product names and show logo', async ({ page }) => {
        const home = new HomePage(page);
        await home.goto();

        // Assert logo visible
        await expect(home.logo).toBeVisible();

        // Get product names and assert at least 1
        const names = await home.getAllProductNames();
        console.log('Products found:', names.length);
        expect(names.length).toBeGreaterThan(0);

        // Optional: print first 3
        for (let i = 0; i < Math.min(3, names.length); i++) console.log(names[i]);
    });
});