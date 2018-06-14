# domainqlstarter 

Skeleton project for domainql based projects.


## Included Technologies

The starter project includes the following libraries / technologies:

### Server

 * maven spring boot 2.0 project
 * GraphQL Endpoint based on graphql-java / domainql
 * Example logic ( DomainqlstarterLogic )
 
### JavaScript Build
 
 * Webpack 4 
 * Babel 
 * mini-css-extract for CSS module imports
 * shelljs as scripting helper
 * Mocha tests with power-asserts (integrated into maven build)
 
### Client

 * React
 * react-router
 * reactstrap
 * redux
 * domainql-form (domainql wrapper for typed formik forms)

## Prequisites

 * [Maven](https://maven.apache.org/download.cgi) 3.5.0 (the spring boot projects come with an alternate mvnw/mvnw.cmd that might also work)
 * [NodeJs](https://nodejs.org/en/download/) v8.11.3+ 
 * [Yarn](https://yarnpkg.com/) v1.7.0+ 
 
## Usage

 * Clone this repository and make sure to change the git remote to your new project repository
 * Customize everything to your liking
   * Everything named "domainqlstarter" has to be renamed / changed. 
   * I have marked a lot of places in src/ and pom.xml with "TODO:" 

## Building

The maven build builds both Java and JavaScript in one step and executes tests for both. It
produces a Spring Boot executable WAR. It can be just run from the command line, although the
preferred development workflow is to use a local tomcat server from within the Intellij IDE. 

### IntelliJ: Shared Run/Debug Configurations

There are two shared run/debug configurations for intellij defined :

 * "Local Tomcat" - Executes the WAR in a Tomcat 8 instance (nothing special, you might have to install Tomcat 8 if you don't have it already)
 * "All Js Tests" - a run/debug definition for the JavaScript tests set up with the special way to make
 mocha understand modern JavaScript (babel) including the extra transforms for power-asserts.
 
## Running the JavaScript Build 

The JavaScript build can be run on its own. The package.json defines several scripts

```sh
yarn run watch
```

Do a development build and enter watch mode. The build job does not end but instead watches
all build files for changes and automatically recompiles them.

```sh
yarn run build-dev
```

Run a development build (no wait)

```sh
yarn run build
```

Run a production build

```sh
yarn test
```

Run the JavaScript tests.
