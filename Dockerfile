FROM jboss/wildfly
ADD ./target/*.war /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080