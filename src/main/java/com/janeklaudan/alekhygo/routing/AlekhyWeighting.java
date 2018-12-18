package com.janeklaudan.alekhygo.routing;

import com.graphhopper.routing.util.FlagEncoder;
import com.graphhopper.routing.weighting.FastestWeighting;
import com.graphhopper.util.EdgeIteratorState;
import com.graphhopper.util.PMap;

import java.util.HashSet;

public class AlekhyWeighting extends FastestWeighting {

    private final HashSet<Integer> edgesToAvoid;

    public AlekhyWeighting(FlagEncoder encoder, PMap map, HashSet<Integer> edgesToAvoid) {
        super(encoder, map);
        this.edgesToAvoid = edgesToAvoid;
    }

    @Override
    public double calcWeight(EdgeIteratorState edge, boolean reverse, int prevOrNextEdgeId) {

        double weight = super.calcWeight(edge, reverse, prevOrNextEdgeId);
        if (edgesToAvoid.contains(edge.getEdge()))
            weight = weight * 1000;
        return weight;
    }
}
