const {test, expect} = require('@playwright/test');
test("Multiple elements locator on the homepage", async ({page}) => {
    // Navigate to the homepage
    await page.goto('https://demoblaze.com/index.html');    
    /* Locator for multiple elements using class name
    const links = await page.$$('a');
    for (const link of links) {
    const linkText = await link.textContent();
    console.log('Linktext);
}
    */
    // Locator for multiple elements using XPath
       
    const products = await page.$$("//div[@id='tbodyid']//div/h4/a")
    for(const product of products)
        {
            const productName = await product.textContent();
            console.log(productName) 

        }
    });

