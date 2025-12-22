const { test, expect } = require('@playwright/test');
const { HomePage } = require('../pages/HomePage');
const { ProductPage } = require('../pages/ProductPage');

test.describe('Product interactions (POM)', () => {
    test('clicking a product opens product page with correct title', async ({ page }) => {
        const home = new HomePage(page);
        await home.goto();

        const names = await home.getAllProductNames();
        expect(names.length).toBeGreaterThan(0);

        // Click first product
        const firstName = names[0];
        await home.clickProductByName(firstName);

        const product = new ProductPage(page);
        const title = await product.getTitle();
        expect(title).toContain(firstName.trim());
    });
});