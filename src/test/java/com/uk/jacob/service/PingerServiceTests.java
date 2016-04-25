package com.uk.jacob.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uk.jacob.SimplePingApplication;
import com.uk.jacob.adapter.HttpAdapter;
import com.uk.jacob.model.Website;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimplePingApplication.class)
@WebAppConfiguration
public class PingerServiceTests {

    @Mock
    HttpAdapter httpAdapter;

    @Mock
    HttpURLConnection mockHttpURLConnection;
    
    @Autowired
    @InjectMocks
    PingerService pingerService;
    
    @Before
    public void setupTests(){
    	MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPingerServiceReturnsOkWhenServiceIsUp() throws IOException{
    	Mockito.when(mockHttpURLConnection.getResponseCode()).thenReturn(200);
        Mockito.when(httpAdapter.createHttpURLConnection("https://jacob.uk.com")).thenReturn(mockHttpURLConnection);

        Website website = pingerService.ping("https://jacob.uk.com");
        
        assertEquals("https://jacob.uk.com", website.url);
        assertEquals(true, website.response);
        assertEquals(200, website.responseCode);
    }

    @Test
    public void testPingerServiceReturnsOkWhenServiceIsNotFound() throws IOException{
        Mockito.when(mockHttpURLConnection.getResponseCode()).thenReturn(404);
        Mockito.when(httpAdapter.createHttpURLConnection("https://jacob.uk.com")).thenReturn(mockHttpURLConnection);

        Website website = pingerService.ping("https://jacob.uk.com");
        
        assertEquals("https://jacob.uk.com", website.url);
        assertEquals(true, website.response);
        assertEquals(404, website.responseCode);
    }

    @Test
    public void testPingerServiceReturnsOkWhenServiceIsDown() throws IOException{
    	Mockito.when(mockHttpURLConnection.getResponseCode()).thenReturn(404);
        Mockito.when(httpAdapter.createHttpURLConnection("http://devnews.today")).thenThrow(new IOException());

        Website website = pingerService.ping("https://jacob.uk.com");

        assertEquals("https://jacob.uk.com", website.url);
        assertEquals(false, website.response);
        assertEquals(0, website.responseCode);
    }

}