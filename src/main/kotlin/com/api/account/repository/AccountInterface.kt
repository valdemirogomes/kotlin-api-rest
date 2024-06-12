import org.springframework.data.jpa.repository.JpaRepository


interface AccountInterface: JpaRepository<Account, Long> {
}