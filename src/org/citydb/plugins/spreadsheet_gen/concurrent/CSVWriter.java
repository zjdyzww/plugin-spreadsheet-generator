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
package org.citydb.plugins.spreadsheet_gen.concurrent;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.citydb.api.concurrent.DefaultWorkerImpl;
import org.citydb.plugins.spreadsheet_gen.concurrent.work.RowofCSVWork;



// TODO: Auto-generated Javadoc
/**
 * The Class CSVWriter.
 */
public class CSVWriter extends DefaultWorkerImpl<RowofCSVWork>{

	/** The bw. */
	BufferedWriter bw;
	
	/** The osw. */
	OutputStreamWriter osw;
	
	/** The fos. */
	FileOutputStream fos;
	
	/** The counting storage. */
	private static HashMap<Integer,AtomicInteger> countingStorage= new HashMap<Integer, AtomicInteger>();
	
	/**
	 * Instantiates a new CSV writer.
	 *
	 * @param output the output
	 */
	public CSVWriter(File output){	
		
		try{
//		FileWriter fw = new FileWriter(output);
//		bw = new BufferedWriter(fw);
		fos = new FileOutputStream(output);
//		bw= new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
//		osw= new OutputStreamWriter(fos, "UTF8");
		
		fos = new FileOutputStream(output);
		
		}catch (Exception e){
//			bw=null;
			osw=null;
			// event
		};
	}
	
	/* (non-Javadoc)
	 * @see org.citydb.api.concurrent.DefaultWorkerImpl#doWork(java.lang.Object)
	 */
	@Override
	public void doWork(RowofCSVWork row) {
		try{
		if (fos!=null){
			fos.write(row.getText().toString().getBytes("UTF-8"));
			synchronized(countingStorage){
				if (row.getClassid()==RowofCSVWork.UNKNOWN_CLASS_ID) return;
				if (countingStorage.containsKey(new Integer(row.getClassid())))
					countingStorage.get(new Integer(row.getClassid())).incrementAndGet();
				else
					countingStorage.put(new Integer(row.getClassid()), new AtomicInteger(1));
			}
		}
		}catch(Exception e){
			// event
		}
	}

	/* (non-Javadoc)
	 * @see org.citydb.api.concurrent.DefaultWorkerImpl#shutdown()
	 */
	@Override
	public void shutdown() {
		try{
			fos.flush();
			fos.close();
		}catch(Exception e){}
		
	}
	
	/**
	 * Reset log storage.
	 */
	public static void resetLogStorage(){
		countingStorage.clear();
	}

	/**
	 * Gets the rport structure.
	 *
	 * @return the rport structure
	 */
	public static HashMap<Integer,AtomicInteger> getRportStructure(){
		
		return countingStorage;
	}
	
	
}
