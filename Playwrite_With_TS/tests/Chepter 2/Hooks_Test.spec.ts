import {test, expect, Browser, Page, Locator, defineConfig } from '@playwright/test'
import { webkit, chromium, firefox } from '@playwright/test'


test.beforeAll(async()=>{
    console.log("Run Before All")
});

test.beforeEach(async()=>{
    console.log("Run Before Each")
});

test.afterAll(async()=>{
    console.log("Run After All")
});

test.afterEach(async()=>{
    console.log("Run After Each")
});

test("First test Running",async()=>{
    console.log("This is First Test")
});

test("Second test Running",async()=>{
    console.log("This is Second Test")
});