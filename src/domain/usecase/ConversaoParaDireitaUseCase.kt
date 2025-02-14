package domain.usecase

import domain.model.Carro

class ConversaoParaDireitaUseCase {
    fun executar(carro: Carro) {

        if (carro.velocidade < 1 ) {
            println("⚠️ A velocidade está muito baixa para fazer conversao ")
            return
        }

        if (carro.velocidade > 40) {
            println("⚠️ A velocidade está muito alta para fazer conversão! Reduza a velocidade!")
            return
        }

        carro.direcao = "Direita"
    }

}