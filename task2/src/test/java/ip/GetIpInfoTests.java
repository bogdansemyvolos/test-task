package ip;

import static utils.EnvProperties.accessKey;
import static utils.EnvProperties.baseURL;

import java.util.HashMap;
import java.util.Map;

import apiclients.BaseAPIClient;
import apiwrappers.RequestWrapper;
import apiwrappers.ResponseWrapper;
import models.IpInfo;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GetIpInfoTests {
    private static final String URL = baseURL();
    private static final String IP = "134.201.250.155";
    private BaseAPIClient apiClient;
    private SoftAssert softAsserts;
    private static final Map<String, String> PARAMETERS = new HashMap<>() {{
        put("access_key", accessKey());
    }};

    @BeforeMethod
    public void init() {
        apiClient = new BaseAPIClient();
        softAsserts = new SoftAssert();
    }


    @Test
    public void getLatitudeAndLongitude() {
        RequestWrapper<IpInfo> requestWrapper = RequestWrapper.<IpInfo>builder()
                .queryParameters(PARAMETERS)
                .build();

        ResponseWrapper<IpInfo> responseWrapper = apiClient.getEntity(IpInfo.class, requestWrapper
                , URL + IP);

        softAsserts.assertEquals(responseWrapper.getStatusCode(), 200
                , "Response status code should be 200");
        softAsserts.assertEquals(responseWrapper.getBody().getLatitude(), 34.0655, 0.01
                , "Latitude should be correct");
        softAsserts.assertEquals(responseWrapper.getBody().getLongitude(), -118.2405, 0.01
                , "Longitude should be correct");
        softAsserts.assertAll();
    }
}
