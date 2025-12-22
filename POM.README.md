# Playwright POM samples for demoblaze

This project contains a small Page Object Model (POM) implementation for https://demoblaze.com/index.html

Files added:
- `pages/HomePage.js` — selectors and helpers for the homepage
- `pages/ProductPage.js` — simple helpers for product page interactions
- `tests-reulst/POM.Homepage.spec.js` — POM test that asserts the brand and product list
- `tests-reulst/POM.Product.spec.js` — POM test that clicks the first product and validates title

Run the POM tests:
- npm script: `npm run test:pom`
- or directly: `npx playwright test POM.* --project=chromium --headed`

Notes & tips:
- Project uses existing `playwright.config.js` which sets `testDir` to `./tests-reulst`; tests are placed there so Playwright discovers them.
- Page objects live in `pages/` and are CommonJS modules to match project setup.
- I used waits in `HomePage.goto()` and `getAllProductNames()` to ensure the product list renders before accessing it.

Updates made in this iteration:
- Added page objects for Cart (`pages/CartPage.js`) and Login (`pages/LoginPage.js`)
- Added tests `tests-reulst/POM.Cart.spec.js` and `tests-reulst/POM.Login.spec.js`
- Added a GitHub Actions workflow at `.github/workflows/playwright.yml` to run the POM tests on push/PR

If you'd like, I can:
- Convert files to TypeScript
- Add more pages (e.g., Cart checkout, Signup) or test cases

Allure integration:
- Run with: `npm run test:allure` (runs tests and generates an Allure report in `allure-report/`)
- Generate only: `npm run allure:generate`
- Open report locally: `npm run allure:open` (falls back to `allure serve` if `allure open` is not available)

CI: The GitHub Actions workflow now generates the Allure report and uploads it as an artifact named `allure-report`.
