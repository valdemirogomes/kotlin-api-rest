package com.api.account

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/accounts")
class AccountController(private val repository: AccountInterfaceRepository) {

    @PostMapping
    fun create(@RequestBody account: Account): ResponseEntity<Account> =
       ResponseEntity.status(HttpStatus.CREATED).body(repository.save(account));

    @GetMapping
    fun getAll(): ResponseEntity<List<Account>> =
        ResponseEntity.ok(repository.findAll())

}