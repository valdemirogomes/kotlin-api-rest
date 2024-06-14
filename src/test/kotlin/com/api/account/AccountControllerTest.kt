package com.api.account

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers



@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest {
    @Autowired lateinit var mockMvc: MockMvc

    @Autowired lateinit var accountRepository:AccountInterfaceRepository

    @Test
    fun `test get all`(){
        mockMvc.perform(MockMvcRequestBuilders.get("/accounts"))
            .andExpect(MockMvcResultMatchers.status().isOk)

    }

    @Test
    fun `test create account`() {
        val account = Account(name = "José", document = "04598523356", phone = "45998786300")
        val json = ObjectMapper().writeValueAsString(account)
        //accountRepository.deleteAll()
        mockMvc.perform(MockMvcRequestBuilders.post("/accounts")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(json))
            .andExpect(MockMvcResultMatchers.status().isCreated)


    }
}