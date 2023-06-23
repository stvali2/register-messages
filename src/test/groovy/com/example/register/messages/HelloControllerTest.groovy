package com.example.register.messages

import com.example.register.messages.HelloController
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@AutoConfigureMockMvc
@WebMvcTest(controllers = HelloController)
class HelloControllerTest extends Specification {

    @Autowired
    private MockMvc mockMvc

    def "finding hello world messages should work"() {
        given: 'an test controller'

        when: 'get request is performed'
        ResultActions response = mockMvc.perform(get("/api/v1/hello"))

        then: 'response status should be 200'
        response.andReturn().response.getStatus() == HttpServletResponse.SC_OK
        and: 'message services get all should be called'
        response.andReturn().response.contentAsString == "Hello world!"
    }
}
