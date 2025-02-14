package domain.usecase

import domain.model.Carro
import domain.model.Marcha

class ReduzirMarchaUseCase {
    fun executar(carro: Carro) {

        if (carro.marcha == Marcha.NEUTRO) {
            println("⚠️ O carro está em NEUTRO, não é possível reduzir a Marcha.")
            return
        }

        carro.marcha = carro.marcha.anterior()!!
        println("A MARCHA foi reduzida para ${carro.marcha}")
    }
}