import {test, expect, Browser, Page, Locator } from '@playwright/test'
import { webkit, chromium, firefox } from '@playwright/test'

test('Login Test Case', async () =>{

    const browser:Browser = await chromium.launch({headless: false});
    const page:Page = await browser.newPage();

    await test.step('Navigate to Url and Validate Home Page Title', async()=>{

        await page.goto('https://naveenautomationlabs.com/opencart/index.php');

        const title = await page.title();
        await expect(title).toEqual('Your Store')

    })

    await test.step('Selecting Login From My Account dropdown', async()=>{
        const myAccount:Locator = await page.locator("[title='My Account']");
        const LoginDropDown:Locator = await page.getByText('Login');

        await myAccount.click();
        await LoginDropDown.click();
    })
   

    await test.step('Validating Lables and Entering Value for Login',async()=>{
        const Logintitle = await page.title();
        await expect(Logintitle).toBe('Account Login')

        const emailId: Locator = await page.locator('#input-email');
        const password: Locator = await page.locator('#input-password'); 

        await emailId.fill("pwtest@opencart.com");
        await password.fill("playwright@123");
    })

    
    await test.step("Login btn click", async()=>{
        const loginButton: Locator = await page.locator("[value='Login']");
        await loginButton.click();
    })
    
    await test.step("Validate Dashboard Title and Screenshort", async()=>{
        const homePagetitle = await page.title();
        console.log("home page title: ", homePagetitle);

        await page.screenshot({path: 'homepage.png'}) 

        await expect(homePagetitle).toEqual('My Account')
    })
})