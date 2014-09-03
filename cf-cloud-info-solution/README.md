cf-cloud-info-solution
======================

Worked solution to the lab for the second Java Applications section showing how to access information about the Cloud enviuronmant and its services.

Usage
-----

To build: use maven or gradle.

To run: edit the `manifest.yml`, fix the `path` and make the `host` unique

Details
-------

A simple, one-page web-application is provided that shows you:

  * the application environment
  * available services
  * properties of the application instance
  * properties of the Cloud environment

Code is implemented using Spring MVC Controllers and Spring Cloud APIs.

Because it is easier to test applications running locally before pushing them to Cloud Foundry, the code quietly returns null information when no Cloud environment is detected. In ths way, you can check the application runs correctly before pushing.

The application uses Spring Boot for configuration and setup.
