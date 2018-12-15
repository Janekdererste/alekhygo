package com.janeklaudan.alekhygo.bootstrap;

import com.bedatadriven.jackson.datatype.jts.JtsModule;
import com.graphhopper.GraphHopper;
import com.graphhopper.jackson.GraphHopperModule;
import com.graphhopper.resources.I18NResource;
import com.graphhopper.resources.InfoResource;
import com.graphhopper.resources.RouteResource;
import com.graphhopper.routing.util.EncodingManager;
import com.janeklaudan.alekhygo.routing.GraphhopperAlekhya;
import io.dropwizard.Application;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class App extends Application<AppConfigruation> {

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    private final GraphHopper graphHopper;

    public App() {
        this.graphHopper = new GraphhopperAlekhya();
    }

    @Override
    public void initialize(Bootstrap<AppConfigruation> bootstrap) {

        bootstrap.getObjectMapper().registerModule(new JtsModule());
        bootstrap.getObjectMapper().registerModule(new GraphHopperModule());

        bootstrap.addBundle(new ConfiguredAssetsBundle("/assets/", "/maps/", "index.html"));
    }

    @Override
    public void run(AppConfigruation configuration, Environment environment) throws Exception {


        this.graphHopper.setDataReaderFile(configuration.getOsmFile());
        this.graphHopper.setGraphHopperLocation(configuration.getTmpFiles());
        this.graphHopper.setEncodingManager(new EncodingManager("foot"));
        this.graphHopper.importOrLoad();

        RouteResource routing = new RouteResource(this.graphHopper, false);
        environment.jersey().register(routing);
        environment.jersey().register(new I18NResource(graphHopper.getTranslationMap()));
        environment.jersey().register(new InfoResource(graphHopper.getGraphHopperStorage(), false));
        environment.jersey().register(new RootResource());
        environment.servlets().addFilter("cors", CORSFilter.class)
                .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), false, "*");
    }
}
