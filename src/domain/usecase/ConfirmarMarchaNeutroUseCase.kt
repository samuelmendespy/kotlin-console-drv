package domain.usecase

import domain.model.Carro
import domain.model.Marcha

class ConfirmarMarchaNeutroUseCase {
    fun executar(carro: Carro) : Boolean {
        if (carro.marcha == Marcha.NEUTRO) {
            println("⚠️ A marcha está em ponto morto (NEUTRO).")
            return true
        }
        return false
    }
}