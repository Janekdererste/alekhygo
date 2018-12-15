package com.janeklaudan.alekhygo.bootstrap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/")
public class RootResource {

    @GET
    public Response redirectToWebapp() {
        return Response.seeOther(UriBuilder.fromPath("maps/").build()).build();
    }

}
