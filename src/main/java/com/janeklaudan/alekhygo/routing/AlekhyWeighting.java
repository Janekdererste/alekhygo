package com.janeklaudan.alekhygo.routing;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.routing.weighting.FastestWeighting;
import com.graphhopper.util.EdgeIteratorState;
import com.graphhopper.util.PMap;

public class AlekhyWeighting extends FastestWeighting {
    public AlekhyWeighting(FlagEncoder encoder, PMap map) {
        super(encoder, map);
    }

    @Override
    public double calcWeight(EdgeIteratorState edge, boolean reverse, int prevOrNextEdgeId) {

        double weight = super.calcWeight(edge, reverse, prevOrNextEdgeId);
        return weight;
    }
}
