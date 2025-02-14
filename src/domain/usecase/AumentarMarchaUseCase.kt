package domain.usecase

import domain.model.Carro
import domain.model.Marcha

class AumentarMarchaUseCase {
    fun executar(carro: Carro) {

        if (carro.marcha == Marcha.SEXTA) {
            println("⚠️ O carro está na SEXTA marcha, não é possível aumentar a Marcha")
            return
        }

        carro.marcha = carro.marcha.proxima()!!
        println("+ FIM: A MARCHA foi trocada para ${carro.marcha}")
    }

}