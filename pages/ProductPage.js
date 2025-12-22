class ProductPage {
    /** @param {import('@playwright/test').Page} page */
    constructor(page) {
        this.page = page;
        this.title = page.locator('.name');
        this.addToCartButton = page.locator('a', { hasText: 'Add to cart' });
    }

    async getTitle() {
        return (await this.title.textContent()).trim();
    }

    async addToCart() {
        await this.addToCartButton.click();
    }
}

module.exports = { ProductPage };