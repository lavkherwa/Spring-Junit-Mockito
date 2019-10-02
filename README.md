# Spring-Junit-Mockito

Sample reference application for writing unit tests in spring application

- Mock Example [Source Code Link](JunitSpring/src/test/java/com/example/junit/service/TaxServiceMockTest3.java)
- Mock Example without @MockBean [Source Code Link](JunitSpring/src/test/java/com/example/junit/service/TaxServiceMockWithoutBeanTest4.java)
- Spy Example [Source Code Link](JunitSpring/src/test/java/com/example/junit/service/TaxServiceSpyTest4.java)
- Handling Exceptions [Source Code Link](JunitSpring/src/test/java/com/example/junit/service/TaxServiceMockExceptionTest5.java)
- Junit for RestController [Source Code Link](JunitSpring/src/test/java/com/example/junit/resource/StaticResourcesTest.java)

## Disabling annoying log when running tests
- Create a new folder **resources** at src/test/**resources**
- Add following file [logback-test.xml](JunitSpring/src/test/resources/logback-test.xml)
