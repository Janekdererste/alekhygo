package com.janeklaudan.alekhygo.routing;

import com.graphhopper.reader.osm.GraphHopperOSM;
import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.routing.util.HintsMap;
import com.graphhopper.routing.weighting.Weighting;
import com.graphhopper.storage.Graph;

public class GraphhopperAlekhya extends GraphHopperOSM {

    @Override
    public Weighting createWeighting(HintsMap hintsMap, FlagEncoder encoder, Graph graph) {
        return new AlekhyWeighting(encoder, hintsMap);
    }
}
