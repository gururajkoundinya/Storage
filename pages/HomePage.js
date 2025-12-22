class HomePage {
    /** @param {import('@playwright/test').Page} page */
    constructor(page) {
        this.page = page;
        this.products = page.locator('#tbodyid div h4 a');
        // Navbar brand is more reliable than an alt text that may not exist
        this.brand = page.locator('.navbar-brand');
    }

    async goto() {
        await this.page.goto('https://demoblaze.com/index.html');
        // Wait for product list to render
        await this.page.waitForSelector('#tbodyid div h4 a', { state: 'visible', timeout: 5000 });
    }

    async getAllProductNames() {
        await this.page.waitForSelector('#tbodyid div h4 a', { state: 'visible', timeout: 5000 });
        return await this.products.allTextContents();
    }

    async clickProductByName(name) {
        await this.page.locator('#tbodyid div h4 a', { hasText: name }).first().click();
    }

    async isBrandVisible() {
        return await this.brand.isVisible();
    }
}

module.exports = { HomePage };