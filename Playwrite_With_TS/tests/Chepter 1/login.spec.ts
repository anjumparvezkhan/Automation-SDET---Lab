import { test, expect, Browser, Page, defineConfig } from '@playwright/test';
import { webkit, chromium, firefox } from 'playwright';
export default defineConfig({timeout: 120000,})

test.beforeAll(async()=>{
  console.log("Rum before All Test")
})

test.beforeEach(async()=>{
  console.log("Run Before Each")
})

test.afterEach(async()=>{
  console.log("Run After Each")
})

test.afterEach(async()=>{
  console.log("Run After All")
})
test('Validate HomePage Orangehrm', async () => {
  const browser:Browser = await chromium.launch({headless: false});
  const page:Page = await browser.newPage();

  await page.goto('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login');

  // Expect a title "to contain" a substring.
  await expect(page).toHaveTitle(/OrangeHRM/);

  const getusername = await page.getByText('Username : Admin').textContent();
  if (!getusername) throw new Error('Username text not found');
  const username = getusername.split(':')[1]
  console.log("username",username)

  const getpassword = await page.getByText('Password : admin123').textContent();
  if (!getpassword) throw new Error('Password text not found');
  const password = getpassword?.split(':')[1]
  console.log("Password",password)

  await page.getByRole('img', { name: 'company-branding' }).isVisible();

  const loginText = await page.locator('//h5').textContent();
  await expect(loginText?.trim()).toBe('Login')

  const loginLable = await page.locator('div').filter({ hasText: /^Username$/ }).nth(2).textContent()
  await expect(loginLable).toBe('Username')

  await page.getByPlaceholder('Username').fill(username)

  const passwordLable = await page.getByText('Password', { exact: true }).textContent();
  await expect(passwordLable).toBe('Password')

  await page.getByRole('textbox', { name: 'Password' }).fill(password);

  await page.waitForTimeout(10000); // waits 10 seconds

});

test('Validate HomePage Orangehrm 2', async () => {
  const browser:Browser = await chromium.launch({headless: false});
  const page:Page = await browser.newPage();
   test.setTimeout(120000);

  await page.goto('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login');

  // Expect a title "to contain" a substring.
  await expect(page).toHaveTitle(/OrangeHRM/);

  const getusername = await page.getByText('Username : Admin').textContent();
  if (!getusername) throw new Error('Username text not found');
  const username = getusername.split(':')[1]
  console.log("username",username)

  const getpassword = await page.getByText('Password : admin123').textContent();
  if (!getpassword) throw new Error('Password text not found');
  const password = getpassword?.split(':')[1]
  console.log("Password",password)

  await page.getByRole('img', { name: 'company-branding' }).isVisible();

  const loginText = await page.locator('//h5').textContent();
  await expect(loginText?.trim()).toBe('Login')

  const loginLable = await page.locator('div').filter({ hasText: /^Username$/ }).nth(2).textContent()
  await expect(loginLable).toBe('Username')

  await page.getByPlaceholder('Username').fill(username)

  const passwordLable = await page.getByText('Password', { exact: true }).textContent();
  await expect(passwordLable).toBe('Password')

  await page.getByRole('textbox', { name: 'Password' }).fill(password);

  await page.waitForTimeout(10000); // waits 10 seconds

});

