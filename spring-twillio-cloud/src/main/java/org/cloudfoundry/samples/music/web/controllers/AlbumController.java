package org.cloudfoundry.samples.music.web.controllers;

import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.cloudfoundry.samples.music.domain.Album;
import org.cloudfoundry.samples.music.repositories.AlbumRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/albums")
public class AlbumController {
    private static final Logger logger = LoggerFactory.getLogger(AlbumController.class);
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "AC7969b8713578ad1e2a94dd2708de3176";
    public static final String AUTH_TOKEN = "a109ab1d741e15c8d32ecb0e91c5c787";
    private AlbumRepository repository;

    @Autowired
    public AlbumController(AlbumRepository repository) {
        this.repository = repository;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Album> albums(HttpServletRequest request,HttpResponse response) {
        return repository.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET, produces = "application/xml")
    public Response respondToSms(HttpServletRequest request, HttpServletResponse response){

        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID,AUTH_TOKEN);
        String productId =  request.getParameter("Body");
        Response res = null;
        RestTemplate template = new RestTemplate();
        template.setErrorHandler(new SpringMusicResponseErrorHandler());
        String respondTo = request.getParameter("From");
        ResponseEntity<String> entity = null;
        try{
            Map<String, String> params1 = new HashMap<String, String>();
            //params1.put("id", productId);
            //params1.put("phoneNumber", respondTo);
            //String uri = "http://spring-music-sp79.cfapps.io/products/add/{id}/{phoneNumber}";
            String uri = "http://spring-music-sp79.cfapps.io/products/add/"+productId+"/"+respondTo;
            //template.put(uri, null, params1);
             entity = template.exchange(uri, org.springframework.http.HttpMethod.PUT,new HttpEntity<Object>(null),String.class);
            if (HttpStatus.OK.equals(entity.getStatusCode())) {
                Request request1 = new Request(HttpMethod.POST, "/2010-04-01/Accounts/" + ACCOUNT_SID + "/Messages", ACCOUNT_SID);
                request1.addPostParam("From", request.getParameter("To"));
                request1.addPostParam("To", respondTo);
                request1.addPostParam("Body",
                        "Hello, Product " + productId + " has been added to your online shopping bag ");
                res = client.request(request1);
            } else {

                String message = entity.getBody();
                Request request1 = new Request(HttpMethod.POST,"/2010-04-01/Accounts/"+ACCOUNT_SID+"/Messages",ACCOUNT_SID);
                request1.addPostParam("From", request.getParameter("To"));
                request1.addPostParam("To", respondTo);
                request1.addPostParam("Body", message);
                res = client.request(request1);
            }


        }catch(Throwable e){
           e.printStackTrace();
            System.out.println("111111"+e.getMessage());
            System.out.println("22222"+e.getCause().getMessage());
//            String message = entity.getBody();
            Request request1 = new Request(HttpMethod.POST,"/2010-04-01/Accounts/"+ACCOUNT_SID+"/Messages",ACCOUNT_SID);
            request1.addPostParam("From", request.getParameter("To"));
            request1.addPostParam("To", respondTo);
            request1.addPostParam("Body", e.getMessage());
            res = client.request(request1);

        }

        return res;
    }


    public static Throwable getRootCause(Throwable throwable) {
        System.out.println(throwable.getCause());
        if (throwable.getCause() != null)
            return getRootCause(throwable.getCause());

        return throwable;
    }
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public Album add(@RequestBody @Valid Album album) {
        logger.info("Adding album " + album.getId());

        return repository.save(album);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Album update(@RequestBody @Valid Album album) {
        logger.info("Updating album " + album.getId());
        return repository.save(album);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Album getById(@PathVariable String id) {
        logger.info("Getting album " + id);

        return repository.findOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable String id) {
        logger.info("Deleting album " + id);
        repository.delete(id);
    }
}