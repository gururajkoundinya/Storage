const{test,expect}=require('@playwright/test');

test("Locators on the homepage are functioning correctly", async ({page}) => {
    // Navigate to the homepage
    await page.goto('https://demoblaze.com/index.html');    

    // Locator by ID
    await page.locator('#login2').click();
    // passing the username and password
    await page.locator('#loginusername').fill('gk1@gmail.com');
    await page.locator('#loginpassword').fill('123456');
    // Clicking on the login button
   const Logoutlink = await page.click("button[onclick='logIn()']");
    //logout link locator by text
    const logoutlink = await page.locator('text=Log out');
    await expect(logoutlink).toBeVisible(); 
    await page.close();
});
