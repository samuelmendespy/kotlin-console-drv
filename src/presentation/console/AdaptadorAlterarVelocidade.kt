package presentation.console

import domain.model.Carro
import domain.usecase.AlterarVelocidadeUseCase

class AdaptadorAlterarVelocidade (
    private val alterarVelocidadeUseCase: AlterarVelocidadeUseCase
) {

    fun executar(carro: Carro, variacao: Int?) {

        if (variacao == null || variacao == 0) {
            println("Sem mudança: A variação da velocidade é nula")
            return
        }

        if (variacao < 0) {
            println("Realizar Redução de Velocidade")
            alterarVelocidadeUseCase.executar(carro, variacao)
        }

        if (variacao > 0) {
            println("Realizar Aumento de velocidade")
            alterarVelocidadeUseCase.executar(carro, variacao)
        }

    }

}