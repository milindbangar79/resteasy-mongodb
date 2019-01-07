package com.resteasy.mongodb.db;



import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
 

@SuppressWarnings("deprecation")
public class DBConnector {
		
		private Mongo mongo;
		private Datastore ds;
		
		public DBConnector(){
			
			//TODO : Remove hardcoded values post implementing approach for properties file
			String host = "localhost";
			String port = "27017";
			String username = "";
			String password = "";
			String db = "test";
			
			
			try {			
				if (host==null) {
					mongo = new Mongo();
				}
				else {
					mongo = new Mongo(host, Integer.parseInt(port));
				}
			} catch (MongoException e) {
				e.printStackTrace();
			}
			
			try{
				Morphia morphia = new Morphia();
				morphia.mapPackage("com.resteasy.mongodb.domain");
				
				if (host==null) {
					ds = morphia.createDatastore(mongo,"employee-mongo");
					ds.ensureIndexes();
				}
				else {
					ds = morphia.createDatastore(mongo, db, username, password.toCharArray());
					ds.ensureIndexes();
				}
				
			}catch(Exception e){
				e.printStackTrace(System.out);
			}
			
			System.out.println("Mongo Datastore initialized");
			
		}

		
		public Mongo getMongo() {
			return mongo;
		}

		public Datastore getDs() {
			return ds;
		}

}
