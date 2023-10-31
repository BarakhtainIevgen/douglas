package tests;

import dataproviders.ParfumDataProvider;
import enums.Filters;
import enums.TopMenuItems;
import org.testng.annotations.Test;
import pages.DouglasPage;
import pages.ParfumPage;

import static enums.TopMenuItems.PARFUM_LIMITIERT;

public class ParfumTest extends TestBase{
    DouglasPage douglasPage;
    ParfumPage parfumPage;

    @Test(description = "Verify parfum list relted to filter",
            dataProvider = "ParfumFilter", dataProviderClass = ParfumDataProvider.class)
    public void CheckParfumList(TopMenuItems parfum, String marke, String produktart, String geschenkFur, String furWen) {
        douglasPage = new DouglasPage(driver);
        douglasPage.acceptCookies();

        if (parfum == PARFUM_LIMITIERT){
            douglasPage.search(PARFUM_LIMITIERT.getChildMenuName());
        } else {
            douglasPage.selectMenuItem(parfum);
        }

        parfumPage = new ParfumPage(driver);
        parfumPage.appyFilter(Filters.MARKE, marke);
        parfumPage.appyFilter(Filters.PRODUKTART, produktart);
        parfumPage.appyFilter(Filters.GESCHENK_FUR, geschenkFur);
        parfumPage.appyFilter(Filters.FUR_WEN, furWen);

        parfumPage.printParfumInfo();
    }
}
