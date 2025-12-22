class LoginPage {
    /** @param {import('@playwright/test').Page} page */
    constructor(page) {
        this.page = page;
        this.loginButton = page.locator('#login2');
        this.loginModal = page.locator('#logInModal');
        this.username = page.locator('#loginusername');
        this.password = page.locator('#loginpassword');
        this.submit = page.locator('#logInModal .modal-footer button', { hasText: 'Log in' });
    }

    async openLoginModal() {
        await this.loginButton.click();
        await this.page.waitForSelector('#logInModal', { state: 'visible', timeout: 5000 });
    }

    async login(username, password) {
        await this.openLoginModal();
        await this.username.fill(username);
        await this.password.fill(password);
        await this.submit.click();
    }

    async isModalVisible() {
        return await this.loginModal.isVisible();
    }
}

module.exports = { LoginPage };