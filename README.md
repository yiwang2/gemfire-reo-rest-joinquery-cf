# gemfire-reo-rest-joinquery-cf
pivotal cloud found version of gemfire-reo-rest-joinquery

## Tips
1. Cannot use client side annotation such as onRegion onServer on Interface to mask server side function. 
PCF cannot recognize them as a proper bean. To execute server side function, 
please look at ExtendedBookMasterRepositories at gemfire-hello-rep module
2. need to upload jars of domian and function to make sure deserilization working
3. Example of client application POM is at gemfire-hello-rep module

## Access PCF service
1. need to create a pcc service from pivotal market place (cf marketplace | grep p-)
2. need to create a service instance by using p-cloudcache (cf create-service)
3. need to create service key of pcc (cf create-service-key)
4. connect remote locator provided by PCF
connect --url=https://cloudcache-156c08e8-a4d4-4388-b5c8-d90634ac3d0d.run.pcfone.io/gemfire/v1 
    --user=user_name --password=password --skip-ssl-validation
5. build jars from domain and function modules and deploy them to remote locator by gfsh deploy command
6. build and cf push application from gemfire-hello-rep module
7. by using rest api client to add some data and run get your_pivotal_app_route/books/low_quantity to have the result
sample data can be used at data_json.txt
8. Don't forget to colocated 2 partitioned regions after creation
