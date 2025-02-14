package domain.usecase

import domain.model.Carro

class LigarUseCase {
    fun executar(carro: Carro) {
        if (carro.ligado) {
            println("⚠️ O carro já está ligado")
            return
        }
        carro.ligado = true
        println("O carro foi ligado")
    }
}