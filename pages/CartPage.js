class CartPage {
    /** @param {import('@playwright/test').Page} page */
    constructor(page) {
        this.page = page;
        this.cartRows = page.locator('#tbodyid tr');
    }

    async goto() {
        await this.page.goto('https://demoblaze.com/cart.html');
        // Wait for cart container to be attached; rows may take a moment to appear.
        await this.page.waitForSelector('#tbodyid', { state: 'attached', timeout: 10000 });
    }

    async getCartItemsText() {
        // Wait for rows if they appear; otherwise return empty array
        try {
            await this.page.waitForSelector('#tbodyid tr', { timeout: 10000 });
            return await this.cartRows.allTextContents();
        } catch (e) {
            return [];
        }
    }

    async removeItemByName(name) {
        // Find the row that contains the name and click the Delete link
        const row = this.page.locator('#tbodyid tr', { hasText: name }).first();
        await row.locator('a', { hasText: 'Delete' }).click();
        await this.page.waitForTimeout(500); // small wait for row to be removed
    }
}

module.exports = { CartPage };