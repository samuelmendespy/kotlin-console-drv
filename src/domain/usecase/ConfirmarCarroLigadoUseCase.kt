package domain.usecase

import domain.model.Carro

class ConfirmarCarroLigadoUseCase {
    fun executar(carro: Carro) : Boolean {
        if (carro.ligado) {
            println("⚠️ O carro está desligado.")
            return true
        }
        println("⚠️ O carro está desligado.")
        return false
    }
}