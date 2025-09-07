package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.dtos.SimCard;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;

    private SimCard simCard;


    @Given("a valid sim card")
    public void aValidSimCard(){
        simCard = new SimCard("1255789453849037777", "test@gmail.com", false);
    }

    @Given("an invalid sim card")
    public void anInvalidSimCard(){
        simCard = new SimCard("8944500102198304826", "test2@gmail.com", false);
    }


    @When("a request is sent to activate the sim card")
    public void aRequestIsSentToActivateTheSimCard() {
        restTemplate.postForObject("http://localhost:8080/sim/activate", simCard, String.class);
    }

    @Then("the sim card should be activated successfully and its status recorded in the database")
    public void theSimCardShouldBeActivatedSuccessfullyAndItsStatusRecordedInTheDatabase() {
        var simCard = restTemplate.getForObject("http://localhost:8080/sim/query?id={id}", SimCard.class, 1);
        assertTrue(simCard.getActive());
    }

    @Then("the activation should fail and its status recorded in the database")
    public void theActivationShouldFailAndItsStatusRecordedInTheDatabase() {
        var simCard = restTemplate.getForObject("http://localhost:8080/sim/query?id={id}", SimCard.class, 2);
        assertFalse(simCard.getActive());
    }
}