package presentation.console

import domain.model.Carro
import domain.usecase.*
import kotlin.math.abs

class Menu (
    private val adaptadorAlterarVelocidade: AdaptadorAlterarVelocidade
    ){
    private val desligarUseCase = DesligarUseCase()
    private val ligarUseCase = LigarUseCase()
    private val confirmarCarroLigadoUseCase = ConfirmarCarroLigadoUseCase()
    private val confirmarMarchaNeutroUseCase = ConfirmarMarchaNeutroUseCase()
    private val aumentarMarchaUseCase = AumentarMarchaUseCase()
    private val reduzirMarchaUseCase = ReduzirMarchaUseCase()
    private val conversaoParaDireitaUseCase = ConversaoParaDireitaUseCase()
    private val conversaoParaEsquerdaUseCase = ConversaoParaEsquerdaUseCase()

    fun exibir(carro: Carro) {

        while (true) {
            println("\nMenu Principal")
            println("1 - Ligar o carro")
            println("2 - Desligar o carro")
            println("3 - Frear (Reduzir velocidade)")
            println("4 - Acelerar (Aumentar velocidade)")
            println("5 - Reduzir marcha")
            println("6 - Aumentar marcha")
            println("7 - Virar à direita")
            println("8 - Virar à esquerda")
            println("0 - Sair")

            when (readLine()?.toIntOrNull()) {
                1 -> {
                    println("\nLIGAR O CARRO")
                    ligarUseCase.executar(carro)
                }

                2 -> {
                    println("\nDESLIGAR O CARRO")
                    desligarUseCase.executar(carro)
                }

                3 -> {
                    println("\nDIMINUIR VELOCIDADE")

                    if (!isCarroLigado(carro)) continue

                    println("Digite um número para decrementar da velocidade")

                    val variacao = readlnOrNull()?.toIntOrNull() ?: 0

                    adaptadorAlterarVelocidade.executar(carro, - abs(variacao))
                }

                4 -> {
                    println("\nACELERAR")

                    if (!isCarroLigado(carro)) continue

                    if (isMarchaNeutro(carro)) continue

                    println("Digite um número para incrementar a velocidade")

                    val variacao = readlnOrNull()?.toIntOrNull() ?:0

                    adaptadorAlterarVelocidade.executar(carro, abs(variacao))
                }

                5 -> {
                    println("\nREDUZIR MARCHA DO CARRO")

                    if (!isCarroLigado(carro)) continue

                    reduzirMarchaUseCase.executar(carro)
                }

                6 -> {
                    println("AUMENTAR MARCHA DO CARRO")

                    if (!isCarroLigado(carro)) continue

                    aumentarMarchaUseCase.executar(carro)
                }

                7 -> {
                    println("CONVERSÃO PARA DIREITA")

                    if (!isCarroLigado(carro)) continue

                    conversaoParaDireitaUseCase.executar(carro)
                }

                8 -> {
                    println("CONVERSÃO PARA ESQUERDA")

                    if (!isCarroLigado(carro)) continue

                    conversaoParaEsquerdaUseCase.executar(carro)
                }

                0 -> break

                else -> println("Opção inválida")
            }
        }
    }

    private fun isCarroLigado(carro: Carro): Boolean {
        if (confirmarCarroLigadoUseCase.executar(carro)) {
            return true
        }
        return false
    }

    private fun isMarchaNeutro(carro: Carro): Boolean {
        if (confirmarMarchaNeutroUseCase.executar(carro)) {
            return true
        }
        return false
    }
}