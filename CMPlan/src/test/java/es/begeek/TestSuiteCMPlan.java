package es.begeek;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.begeek.Controller.TestSuiteAction;
import es.begeek.service.TestSuiteService;

@RunWith(Suite.class)
@SuiteClasses({TestSuiteAction.class, TestSuiteService.class})
public class TestSuiteCMPlan { }
