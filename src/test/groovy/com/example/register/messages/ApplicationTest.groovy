package com.example.register.messages

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application)
class ApplicationTest extends Specification {

    @Autowired
    private Environment environment

    def "check if application exist"() {
        expect:
        environment != null
    }
}
