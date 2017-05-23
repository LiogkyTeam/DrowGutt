DrowGutt
==============

The application is built on the basis of the Vaadin framework and requires only a servlet 3.0 container to run

Workflow
========

To compile the entire project, run "mvn install".

To run the application, run "mvn jetty:run" and open http://localhost:8080/ .

To produce a deployable production mode WAR:
- change productionMode to true in the servlet class configuration (nested in the UI class)
- run "mvn clean package"
- test the war file with "mvn jetty:run-war"

Our structure
-------------------------

Multi-functional graphical editor. 
Presentation here: https://prezi.com/if_4fn-t9gvw/edit/#0
