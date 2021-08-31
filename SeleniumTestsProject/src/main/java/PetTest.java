import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import rest.PetService;

public class PetTest {

    String barsik = "{\n" +
            "  \"id\": 123321,\n" +
            "  \"category\": {\n" +
            "    \"id\": 100,\n" +
            "    \"name\": \"dogCategory\"\n" +
            "  },\n" +
            "  \"name\": \"barsik\",\n" +
            "  \"photoUrls\": [],\n" +
            "  \"tags\": [],\n" +
            "  \"status\": \"available\"\n" +
            "}";

    int barsikId = 123321;

    @Test
    public void defaultPetFlow() {
        PetService store = new PetService();

        Response createResponse = store.createPet(barsik);
        Assert.assertEquals(createResponse.getStatusCode(), 200);
        Assert.assertNotNull(createResponse.getBody());

        Response getAfterCreateResponse = store.getPet(barsikId);
        Assert.assertEquals(getAfterCreateResponse.getStatusCode(), 200);
        Assert.assertNotNull(getAfterCreateResponse.getBody());

        Response updateResponse = store.updatePet(barsik.replace("available", "sold"));
        Assert.assertEquals(updateResponse.getStatusCode(), 200);
        Assert.assertNotNull(updateResponse.getBody());

        Response getAfterUpdateResponse = store.getPet(barsikId);
        Assert.assertEquals(getAfterUpdateResponse.getStatusCode(), 200);
        Assert.assertNotNull(getAfterUpdateResponse.getBody());
        Assert.assertTrue(getAfterUpdateResponse.getBody().asString().contains("sold"));

        Response removeResponse = store.removePet(barsikId);
        Assert.assertEquals(removeResponse.getStatusCode(), 200);
        Assert.assertNotNull(removeResponse.getBody());

        Response getAfterRemoveResponse = store.getPet(barsikId);
        Assert.assertEquals(getAfterRemoveResponse.getStatusCode(), 404);

    }
}
