package com.janeklaudan.alekhygo.routing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphhopper.reader.osm.GraphHopperOSM;
import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.routing.util.HintsMap;
import com.graphhopper.routing.weighting.Weighting;
import com.graphhopper.storage.Graph;
import lombok.Setter;
import org.geojson.FeatureCollection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;

public class GraphhopperAlekhya extends GraphHopperOSM {

    @Setter
    private Path geoJsonfile;

    @Setter
    private ObjectMapper objectMapper;

    public GraphhopperAlekhya() {
    }

    @Override
    public Weighting createWeighting(HintsMap hintsMap, FlagEncoder encoder, Graph graph) {


        HashSet<Integer> edgesToAvoid = null;
        try {
            edgesToAvoid = parseGeoJsonToEdgesToAvoid(graph);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not create edges to avoid");
        }
        return new AlekhyWeighting(encoder, hintsMap, edgesToAvoid);
    }

    private HashSet<Integer> parseGeoJsonToEdgesToAvoid(Graph graph) throws IOException {

        HashSet<Integer> result = new HashSet<>();

        // read the geo json file
        InputStream inputStream = Files.newInputStream(geoJsonfile);
        FeatureCollection features = objectMapper.readValue(inputStream, FeatureCollection.class);

        // iterate over its properties
        double lat, lon;
        features.getFeatures().forEach(feature -> {
            // TODO goole how to find a point and a polygon
        });

        // find edges like in the tutorial

        // put them into the result

        return result;
    }
}
