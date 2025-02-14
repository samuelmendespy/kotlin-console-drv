package domain.usecase

import domain.model.Carro
import domain.model.Marcha

class DesligarUseCase {
    fun executar(carro: Carro) {
        if (!carro.ligado) {
            println("⚠️ O carro já está desligado")
            return
        }

        if (carro.marcha != Marcha.NEUTRO) {
            println("⚠️ O carro deve estar em marcha Neutro.")
            println("Marcha atual: ${carro.marcha}")
            return
        }

        if (carro.velocidade != 0) {
            println("⚠️ O carro deve estar parado a 0 km/h")
            println("Velocidade atual: ${carro.velocidade} km/h ")
            return
        }

        carro.ligado = false
        println("O carro foi desligado")
    }
}