import {test, Page, expect, Browser, Locator} from "@playwright/test";
import { chromium, webkit, firefox } from "@playwright/test";

test('ScrrenShorts', async () => {

    const Browser = await chromium.launch({headless:false});
    const page = await Browser.newPage();

    await test.step('Launch Browser', async()=>{
        await page.goto('https://naveenautomationlabs.com/opencart/index.php');

        //Element Screenshot
        //await page.locator('#logo').screenshot({path: './ScreenShots/ElementScreenshots.png'})

        //Page Screenshot
        // await page.screenshot({path: './ScreenShots/PageScreenshots.png'})


        //Full Page Screenshot
         await page.screenshot({path: './ScreenShots/FullPageScreenshots.png', fullPage:true})



    })
})
