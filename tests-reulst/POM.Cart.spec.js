const { test, expect } = require('@playwright/test');
const { HomePage } = require('../pages/HomePage');
const { ProductPage } = require('../pages/ProductPage');
const { CartPage } = require('../pages/CartPage');

test.describe('Cart (POM)', () => {
    test('should add a product to the cart and show it in the cart', async ({ page }) => {
        const home = new HomePage(page);
        await home.goto();

        const names = await home.getAllProductNames();
        expect(names.length).toBeGreaterThan(0);

        const firstName = names[0];
        await home.clickProductByName(firstName);

        const product = new ProductPage(page);

        // Accept alert that confirms addition to cart
        page.on('dialog', async (dialog) => {
            await dialog.accept();
        });

        await product.addToCart();

        // allow a short moment for server to process the add and for the cart to update
        await page.waitForTimeout(1500);

        // Go to cart and verify
        const cart = new CartPage(page);
        await cart.goto();
        const items = await cart.getCartItemsText();
        expect(items.length).toBeGreaterThan(0);
        // Optional: ensure the product name appears in the cart items' text
        expect(items.join(' ')).toContain(firstName.trim());

        // Cleanup: remove item if present
        await cart.removeItemByName(firstName);
    });
});