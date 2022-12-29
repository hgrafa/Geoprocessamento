package com.geoprocessamento2.geo.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.n52.jackson.datatype.jts.GeoJsonConstants;

import java.beans.FeatureDescriptor;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.geojson.*;

public class ReadJsonFile {
    private ObjectMapper om = new ObjectMapper();
    public void mapToObject(String url) throws Exception {
        Map<String, Object> resultado = om.readValue(new URL(url), new TypeReference<Map<String, Object>>() {});
        List<Feature> features = om.convertValue(resultado.get("features"), new TypeReference<List<Feature>>() {});
        for (Feature feature: features) {
            System.out.println(om.writeValueAsString(feature));
            Map<String, Object> propriedades = feature.getProperties();
            GeoJsonObject geom = feature.getGeometry();
            if(geom instanceof Polygon) {
                Polygon p = (Polygon)geom;
            }
        }
    }
}
