/*
 * LoadMapsActivity 13/02/2013
 *
 * Copyright SystemIntegration India
 * All rights reserved.
 */
package com.prashant.adesara.googlemapv2;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * This is a Activity for handling Google Map
 * 
 * @author Prashant Adesara
 * @url http://prashantandroid.blogspot.in
 **/

public class MapsActivity extends Activity
{
	private LatLng fromPoint, toPoint;

	@Override
	public void onCreate(final Bundle savedState)
	{
		try
		{
			super.onCreate(savedState);
			setContentView(R.layout.activity_main);
			final GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
			
			double fromLat=0.0, fromLon = 0.0, toLat = 0.0, toLon = 0.0;
			
			fromLat  = 22.3000;
			fromLon = 70.7800;
			toLat = 22.337712;
			toLon = 70.888426;
			
			fromPoint = new LatLng(fromLat, fromLon);
			toPoint   = new LatLng(toLat, toLon);
			
			map.addMarker(new MarkerOptions()
				.position(fromPoint)
				.title("Current Location")
				.snippet("Street, Rajkot, GJ.")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.ypin)));
			
			map.addMarker(new MarkerOptions()
				.position(toPoint).title("Last Location")
			 	.snippet("Street 2, Rajkot, GJ")
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.pin)));
			
			map.moveCamera(CameraUpdateFactory.newLatLngZoom(toPoint, 15));
			map.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
    @Override
    protected void onDestroy() {
    	super.onDestroy();
    }
    
}
