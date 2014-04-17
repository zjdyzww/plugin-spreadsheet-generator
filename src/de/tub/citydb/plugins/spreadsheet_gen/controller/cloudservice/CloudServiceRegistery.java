/*
 * This file is part of the Spreadsheet Generator Plugin
 * developed for the 3D City Database Importer/Exporter v1.4.0
 * Copyright (c) 2012
 * Institute for Geodesy and Geoinformation Science
 * Technische Universitaet Berlin, Germany
 * http://www.gis.tu-berlin.de/
 * 
 * The Spreadsheet Generator Plugin program is free software:
 * you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see 
 * <http://www.gnu.org/licenses/>.
 */
package de.tub.citydb.plugins.spreadsheet_gen.controller.cloudservice;

import java.util.LinkedHashMap;
import java.util.Set;

import de.tub.citydb.plugins.spreadsheet_gen.controller.cloudservice.CloudService;

public class CloudServiceRegistery {
	private static CloudServiceRegistery INSTANCE=new CloudServiceRegistery();
	private LinkedHashMap<String, CloudService> servicelist= new LinkedHashMap<String, CloudService>();
	private String currentService="";
	private boolean isServiceSelected=false;
	private CloudServiceRegistery(){
		isServiceSelected=false;
	}
	public static CloudServiceRegistery getInstance() {
		return INSTANCE;
	}
	
	public void registerService(CloudService service, String name){
		servicelist.put(name, service);
	}
	
	public Set<String> getListofServices(){
		return servicelist.keySet();
	}
	
	public boolean selectService(String name){
		if (servicelist.containsKey(name)){
			currentService=name;
			isServiceSelected=true;
			return true;
		}
		isServiceSelected=false;
		return false;
	}
	
	public CloudService getSelectedService(){
		return servicelist.get(currentService);
	}
	
	public boolean isServiceSelected(){
		return isServiceSelected;
	}
	
}