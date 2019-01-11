package com.resteasy.mongodb.db;

import javax.inject.Inject;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import io.xlate.inject.Property;
import io.xlate.inject.PropertyResource;

@SuppressWarnings("deprecation")
public class DBConnector {

	private Mongo mongo;
	private Datastore ds;

	@Inject
	@Property(name = "env.mongodb.host", resource = @PropertyResource("classpath:application.properties"))
	private String host;

	@Inject
	@Property(name = "env.mongodb.port", resource = @PropertyResource("classpath:application.properties"))
	private String port;

	@Inject
	@Property(name = "env.mongodb.username", resource = @PropertyResource("classpath:application.properties"))
	private String username;

	@Inject
	@Property(name = "env.mongodb.password", resource = @PropertyResource("classpath:application.properties"))
	private String password;

	@Inject
	@Property(name = "env.mongodb.dbname", resource = @PropertyResource("classpath:application.properties"))
	private String db;

	public DBConnector() {

		try {
			if (host == null) {
				mongo = new Mongo();
			} else {
				mongo = new Mongo(host, Integer.parseInt(port));
			}
		} catch (MongoException e) {
			e.printStackTrace();
		}

		try {
			Morphia morphia = new Morphia();
			morphia.mapPackage("com.resteasy.mongodb.domain");

			if (host == null) {
				ds = morphia.createDatastore(mongo, "employee-mongo");
				ds.ensureIndexes();
			} else {
				ds = morphia.createDatastore(mongo, db, username, password.toCharArray());
				ds.ensureIndexes();
			}

		} catch (Exception e) {
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
