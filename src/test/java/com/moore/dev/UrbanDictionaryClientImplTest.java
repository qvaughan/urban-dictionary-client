package com.moore.dev;

import com.moore.dev.api.ShitBallsException;
import com.moore.dev.api.UrbanDictionaryClient;
import com.moore.dev.impl.UrbanDictionaryClientImpl;
import com.moore.dev.model.SearchResults;
import org.junit.Assert;
import org.junit.Test;

/**
 * ryanmoore - 8/26/16.
 */
public class UrbanDictionaryClientImplTest {

    @Test
    public void testFindDefinitions() {
        UrbanDictionaryClient client = new UrbanDictionaryClientImpl("<yourApiKeyHere>");
        SearchResults results = null;
        try {
            results = client.findDefinitions("ASSHOLE");
        } catch (ShitBallsException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(results);
    }


}
