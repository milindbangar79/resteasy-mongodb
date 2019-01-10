package com.resteasy.mongodb.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PropertyKey;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.ProcessProducer;

import com.resteasy.mongodb.utils.ServiceException;

public class ConfigurationClass {

	private Properties properties;

	@PropertyKey
	@Produces
	public String produceString(final InjectionPoint ip) {
		return this.properties.getProperty(getKey(ip));
	}

	@PropertyKey
	@Produces
	public int produceInt(final InjectionPoint ip) {
		return Integer.valueOf(this.properties.getProperty(getKey(ip)));
	}

	@PropertyKey
	@Produces
	public boolean produceBoolean(final InjectionPoint ip) {
		return Boolean.valueOf(this.properties.getProperty(getKey(ip)));
	}

	private String getKey(final InjectionPoint ip) {
		return (ip.getAnnotated().isAnnotationPresent(Configuration.class)
				&& !ip.getAnnotated().getAnnotation(Configuration.class).value().isEmpty())
						? ip.getAnnotated().getAnnotation(Configuration.class).value() : ip.getMember().getName();
	}

	@PostConstruct
	public void init() throws ServiceException {
		this.properties = new Properties();
		final InputStream stream = ProcessProducer.class.getResourceAsStream("/application.properties");
		if (stream == null) {
			throw new ServiceException("No properties!!!");
		}
		try {
			this.properties.load(stream);
		} catch (final IOException e) {
			throw new ServiceException("Configuration could not be loaded!",e);
		}
	}

}
