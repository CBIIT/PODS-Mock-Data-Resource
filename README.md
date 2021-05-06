# 
**Approved for Public Release; Distribution Unlimited. Public Release Case Number 21-0554**

# PODS Mock Data Resource Module
This Mock Data Resource module contains a simple web service which simulates a data resource owner's web service. This web service provides an external interface for the PODCat to pull the meta data information of the projects from this data resource by calling this API.  

### Get data files to load
The data files serve the content source of the API. 
Contact NCI for the digest data files and place the files under `src/main/resources/files`. 

## Instruction to run
### Run the following command to build the mock data resource application:

`mvn package`

### Run the following command to execute the mock data resource application:

`java -jar target/mockdataresource-0.1.1-SNAPSHOT.jar --spring.profiles.active=local`

Running this command will create the indices and load the data in to Elasticsearch depending on the command chosen.

### Server endpoints
By default, the service is running on http://localhost:8087

<!-- prettier-ignore -->
| Relative URL                                   | Endpoint Description                  |
|------------------------------------------------|---------------------------------------|
| `/mockdataresource/api/projects/summary`       | Retrieve the meta data of the projects|

# License
This project is licensed under the Apache License 2.0. See [LICENSE](/LICENSE.txt) for more details.

# NOTICE
This (software/technical data) was produced for the U. S. Government under Contract Number 75FCMC18D0047, and is subject to Federal Acquisition Regulation Clause 52.227-14, Rights in Data-General. No other use other than that granted to the U. S. Government, or to those acting on behalf of the U. S. Government under that Clause is authorized without the express written permission of The MITRE Corporation.For further information, please contact The MITRE Corporation, Contracts Management Office, 7515 Colshire Drive, McLean, VA 22102-7539, (703) 983-6000.

© 2021 The MITRE Corporation.
