/*
 * 3D City Database - The Open Source CityGML Database
 * http://www.3dcitydb.org/
 * 
 * Copyright 2013 - 2017
 * Chair of Geoinformatics
 * Technical University of Munich, Germany
 * https://www.gis.bgu.tum.de/
 * 
 * The 3D City Database is jointly developed with the following
 * cooperation partners:
 * 
 * virtualcitySYSTEMS GmbH, Berlin <http://www.virtualcitysystems.de/>
 * M.O.S.S. Computer Grafik Systeme GmbH, Taufkirchen <http://www.moss.de/>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.citydb.plugins.spreadsheet_gen.events;

import org.citydb.plugins.spreadsheet_gen.controller.cloudservice_impl.gui.Users;

import org.citydb.api.event.Event;

// TODO: Auto-generated Javadoc
/**
 * The Class SharingEvent.
 */
public class SharingEvent extends Event {
	
	/** The type. */
	private int type;
	
	/** The user. */
	private Users user;
	
	/** The message. */
	private String message;
	
	/** The message title. */
	private String messageTitle;
	
	/**
	 * Instantiates a new sharing event.
	 *
	 * @param type the type
	 * @param source the source
	 * @param user the user
	 */
	public SharingEvent(int type, Object source, Users user) {
		super(EventType.SHARING_EVENT, GLOBAL_CHANNEL, source);
		this.type = type;
		this.user = user;
	}
	
	/**
	 * Instantiates a new sharing event.
	 *
	 * @param type the type
	 * @param source the source
	 * @param messageTitle the message title
	 * @param message the message
	 */
	public SharingEvent(int type, Object source, String messageTitle,String message) {
		super(EventType.SHARING_EVENT, GLOBAL_CHANNEL, source);
		this.type = type;
		this.user = null;
		this.message=message;
		this.messageTitle=messageTitle;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public int getType() {
		return this.type;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public Users getUser() {
		return this.user;
	}
	
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Gets the message title.
	 *
	 * @return the message title
	 */
	public String getMessageTitle() {
		return messageTitle;
	}
	
	
}
