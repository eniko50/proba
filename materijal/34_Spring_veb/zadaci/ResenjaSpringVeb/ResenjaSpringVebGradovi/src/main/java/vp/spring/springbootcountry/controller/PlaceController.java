package vp.spring.springbootcountry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.springbootcountry.model.Country;
import vp.spring.springbootcountry.model.Place;
import vp.spring.springbootcountry.service.PlaceService;

@RestController
public class PlaceController {
	@Autowired
	PlaceService placeService;
	
	@RequestMapping(value="api/places", method = RequestMethod.GET) 
	public String getAllPlaces() {
		List<Place> places = placeService.findAll();
		
		StringBuffer sb = new StringBuffer();
		for (Place p: places) {
			sb.append(p).append("\n"); 
		}
		
		return sb.toString();
	}
	
	@RequestMapping(value="pages/places", method = RequestMethod.GET) 
	public String getPlacesHtml() {
		List<Place> places = placeService.findAll();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("Zip kod");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Naziv");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Država");
		sb.append("</td>");
		sb.append("</tr>");
		
		for (Place p: places) {
			sb.append("<tr>");
			sb.append("<td>");
			sb.append(p.getZipCode());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(p.getName());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(p.getCountry().getName());
			sb.append("</td>");
			sb.append("</tr>"); 
		}
		
		return sb.toString();
	}
	
	@RequestMapping(value="api/places/{id}", method = RequestMethod.GET) 
	public String getPlace(@PathVariable int id) {
		Place place = placeService.findOne(id);
		
		return place.toString();
	}
	
	@RequestMapping(value="api/places/search", method = RequestMethod.GET) 
	public String getPlacesByName(@RequestParam String name) {
		List<Place> places = placeService.findByName(name);
		
		StringBuffer sb = new StringBuffer();
		for (Place p: places) {
			sb.append(p).append("\n"); 
		}
		
		return sb.toString();
	}
	
	@RequestMapping(value="pages/places/search", method = RequestMethod.GET) 
	public String getPlacesByNameHtml(@RequestParam String name) {
		List<Place> places = placeService.findByName(name);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("Zip kod");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Naziv");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Država");
		sb.append("</td>");
		sb.append("</tr>");
		
		for (Place p: places) {
			sb.append("<tr>");
			sb.append("<td>");
			sb.append(p.getZipCode());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(p.getName());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(p.getCountry().getName());
			sb.append("</td>");
			sb.append("</tr>"); 
		}
		
		return sb.toString();
	}
}
