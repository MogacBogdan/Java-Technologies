# Java-Technologies
Repository for all laboratories from Java Technologies.

# Laboratory 1

* Compulsory part :heavy_check_mark:
    *  Create a servlet that receives a word and returns an HTML page containing the letters of that word presented as an ordered list. 
* Homework part :heavy_check_mark:
    * Created a servlet that receives a string and an integer and return the permutations of that string.
    * Created a dictionary using aspell and returned only the permutations that were in the dictionary.
* Bonus part :heavy_check_mark:
    * Invoke the server from a Desktop application (service-invoker.py)
    * A log file to store HTTP method, IP address, user-agent, client language and parameters, using *Logger*.
    * Analyze concurrency issues and resource contention, invoking the servlet repeatedly, in an asynchronous manner. (service-invoker.py) (TO BE PRESENTED AT LAB 3)

# Laboratory 2
* Compulsory part :heavy_check_mark:
   * A page containing a form for introducing a word and a number: **src/main/webapp/index.jsp**
   * A page describing the response that will be delivered to the client: **src/main/webapp/result.jsp**
* Homework :heavy_check_mark:
   * object oriented model: **src/main/java/com/example/laboratory1/models**.
   * Servlets: **src/main/java/com/example/laboratory1/servlets**.
   * Resources: **src/main/java/com/example/laboratory1/utils**.
   * Filters: **src/main/java/com/example/laboratory1/filters**.
   * web filter that logs all requests received by *input.jsp*: **src/main/java/com/example/laboratory1/filters/LogFilter**.
   * web filter that will decorate the response by adding a specific prelude and specific coda: **src/main/java/com/example/laboratory1/filters/DecoratorFilter**.
   
* Bonus part :heavy_check_mark:
   * web listener that reads a default category specified as a context init parameter at the application start-up. **src/main/java/com/example/laboratory1/listeners/DefaultCategoryListener**
   * Create a "hand-made" cookie to store the category selected by the client.
   * Captcha ( TO BE PRESENTED AT LAB 4 )
