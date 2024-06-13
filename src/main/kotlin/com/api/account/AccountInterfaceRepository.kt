package com.api.account

import org.springframework.data.jpa.repository.JpaRepository


interface AccountInterfaceRepository: JpaRepository<Account, Long> {
}