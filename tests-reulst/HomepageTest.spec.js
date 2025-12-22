const {test, expect}= require('@playwright/test');

test("Homepage has correct title and header", async ({page}) => {
    // Navigate to the homepage
    await page.goto('https://demoblaze.com/index.html');
    const pageTitle = await page.title();
    console.log("Page Title:", pageTitle);
    await expect(page).toHaveTitle('STORE');
    const pageURL = page.url();
    console.log("Page URL:", pageURL);
    await expect (page).toHaveURL('https://demoblaze.com/index.html');
    await page.close();
});
