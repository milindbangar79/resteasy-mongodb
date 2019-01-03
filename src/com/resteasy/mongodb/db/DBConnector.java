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
			
			/*for (DbEnvironmentVariables dbEnv : DbEnvironmentVariables.values()){
				try {
					ValidateEnvironmentVariables.isEnvironmentVariableValid(dbEnv.getEnvVariable());
				} catch (MissingEnvironmentVariableCheckedException e) {
					throw new MissingEnvironmentVariableCheckedException("", e);
				}
			}*/
			
			
			System.out.println("MongoDB Port ::::" + System.getenv("MONGODB_DB_HOST"));
			System.out.println("MongoDb Port::::" + System.getenv("MONGODB_DB_PORT"));
			System.out.println("MongoDB APP Name :::" + System.getenv("APP_NAME"));
			
			String host = "localhost";
			String port = "27017";
			String username = "";
			String password = "";
			String db = "test";
			
			//String host = System.getenv("MONGODB_DB_HOST");
			//String port = System.getenv("MONGODB_DB_PORT");
			//String username = "";
			//String password = "";
			//String db = System.getenv("APP_NAME");
			
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
