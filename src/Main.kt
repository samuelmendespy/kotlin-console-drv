import domain.model.Carro
import domain.usecase.*
import presentation.console.AdaptadorAlterarVelocidade
import presentation.console.Menu

fun main() {
    val carro = Carro()
    val alterarVelocidadeUseCase = AlterarVelocidadeUseCase()
    val adaptadorMudarVelocidade = AdaptadorAlterarVelocidade(alterarVelocidadeUseCase)
    val menu = Menu(adaptadorMudarVelocidade)
    menu.exibir(carro)
}