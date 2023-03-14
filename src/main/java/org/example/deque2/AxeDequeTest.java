package org.example.deque2;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AxeDequeTest extends BaseClass {

    AxeBuilder builder = new AxeBuilder();

    @Test
    public void axeTest(){

        Results results = builder.analyze(driver);
        List<Rule> violations = results.getViolations();
        System.out.println("Total violations are : "+violations.size());
        if (violations.size() == 0)
        {
            Assert.assertTrue(true, "No violations found");
        }
        else{
            System.out.println("Violations found");
        }

    }
}
