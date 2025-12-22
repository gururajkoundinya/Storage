const {test, expect} = require('@playwright/test');
test("Soft assertions demo on the homepage", async ({page}) => {
    // Navigate to the homepage
    await page.goto('https://demoblaze.com/index.html');    
    // Soft assertion for page title
    await expect.soft(page).toHaveTitle('STORE');
    await expect.soft(page).toHaveURL('https://demoblaze.com/index.html');
    await expect.soft(page.locator('.navbar-brand')).toBeVisible();
})
