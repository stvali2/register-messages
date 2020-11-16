package com.example.register.messages.boundary

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import javax.servlet.http.HttpServletResponse

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@AutoConfigureMockMvc
@WebMvcTest(controllers = TestController)
class TestControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    def "finding hello world messages should work"() {
        given: 'an message controller'

        when: 'get request is performed'
        ResultActions response = mockMvc.perform(get("/api/v1/test"))

        then: 'response status should be 200'
        response.andReturn().response.getStatus() == HttpServletResponse.SC_OK
        and: 'message services get all should be called'
        response.andReturn().response.contentAsString == "Hello world!"
    }
}
