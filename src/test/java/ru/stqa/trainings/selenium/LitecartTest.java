package ru.stqa.trainings.selenium;

import org.junit.Test;

public class LitecartTest extends TestBase {


    @Test
    public void litecartLogin() throws InterruptedException {

        adminLogin();

        adminLogout();

    }
}