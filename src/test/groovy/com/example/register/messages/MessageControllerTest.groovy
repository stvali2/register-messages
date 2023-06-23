package com.example.register.messages

import com.example.register.messages.MessageController
import com.example.register.messages.MessageService
import com.example.register.messages.MessageDto
import jakarta.servlet.http.HttpServletResponse
import org.spockframework.spring.SpringBean
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@AutoConfigureMockMvc
@WebMvcTest(controllers = MessageController)
class MessageControllerTest extends Specification {

    private MockMvc mockMvc

    @SpringBean
    private MessageService messageService = Mock(MessageService)

    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new MessageController(messageService)).build()
    }

    def "finding all messages should work"() {
        given: 'an message controller'

        when: 'get request is performed'
        ResultActions response = mockMvc.perform(get("/api/v1/messages"))

        then: 'response status should be 200'
        response.andReturn().response.getStatus() == HttpServletResponse.SC_OK
        and: 'result is successful'
        response.andReturn().response.contentLength == 0
        and: 'message services get all should be called'
        1 * messageService.getAll() >> new ArrayList<MessageDto>()
    }
}
