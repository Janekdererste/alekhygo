package com.janeklaudan.alekhygo.bootstrap;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.bundles.assets.AssetsBundleConfiguration;
import io.dropwizard.bundles.assets.AssetsConfiguration;
import lombok.Getter;

import javax.validation.Valid;

@Getter
public class AppConfigruation extends Configuration implements AssetsBundleConfiguration {

    private String osmFile;
    private String geoJsonFile;
    private String tmpFiles;


    @Valid
    @JsonProperty
    private final AssetsConfiguration assets = AssetsConfiguration.builder().build();

    public AssetsConfiguration getAssetsConfiguration() {
        return assets;
    }
}
