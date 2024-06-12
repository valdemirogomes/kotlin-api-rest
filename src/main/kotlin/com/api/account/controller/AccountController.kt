import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController(private val repository: AccountInterface) {

    @PostMapping
    fun create(@RequestBody account: Account): Account = repository.save(account)

    @GetMapping
    fun findAll():List<Account> = repository.findAll()

    @GetMapping("{/id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Account> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())
}