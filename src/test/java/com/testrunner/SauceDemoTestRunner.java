package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",
        glue = {"stepdefinitions"},
        tags = "@TestCase-7",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class SauceDemoTestRunner {

}