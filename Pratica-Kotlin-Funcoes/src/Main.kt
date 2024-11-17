val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) == null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}

/**
 * Mostra na tela todas as notas presentes em uma matéria e a média das notas.
 */
fun mostrarNotas(materia: String) {
    if (!materiasENotas.containsKey(materia)) {
        println("Materia $materia não encontrada")
    } else {
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null && listaNotas.isNotEmpty()) {
            println("Materia: $materia")
            listaNotas.forEachIndexed { index, nota ->
                println("Nota ${index + 1}: $nota")
            }

            // Calcular e mostrar a média
            val media = calcularMedia(listaNotas)
            println("Média: $media\n")
        } else {
            println("Não foi possível mostrar as notas da matéria $materia\n")
        }
    }
}

/**
 * Retorna a média obtida a partir de uma lista de notas.
 */
fun calcularMedia(notas: List<Double>): Double {
    return if (notas.isNotEmpty()) notas.average() else 0.0
}

/**
 * Adiciona várias notas de uma só vez em uma matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarVariasNotas(materia: String, vararg notas: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.addAll(notas.toList())
        true
    } else {
        false
    }
}

fun main() {
    // 1. Adicionar disciplina através de atribuição posicional
    adicionarDisciplina("Matemática", mutableListOf(8.0, 9.5))

    // 2. Adicionar disciplina através de atribuição nomeada
    adicionarDisciplina(materia = "História", notas = mutableListOf(7.0))

    // 3. O parâmetro notas agora possui um valor padrão (já foi implementado).

    // 4. Adicionar disciplina sem atribuir valores a notas
    adicionarDisciplina("Geografia")

    // 5. Adicionar 3 notas para as 3 disciplinas
    adicionarNota("Matemática", 10.0)
    adicionarNota("História", 8.5)
    adicionarNota("Geografia", 7.5)

    // 6. Mostrar notas das 3 disciplinas
    mostrarNotas("Matemática")
    mostrarNotas("História")
    mostrarNotas("Geografia")

    // 7. Adicionar mais 1 disciplina
    adicionarDisciplina("Física")

    // 8. Implementar o método adicionarVariasNotas (já foi implementado).

    // 9. Adicionar 3 notas para a disciplina "Física"
    adicionarVariasNotas("Física", 8.0, 9.0, 10.0)

    // 10. Mostrar as notas da disciplina "Física"
    mostrarNotas("Física")

    // 11. Implementar a função calcularMedia() (já foi implementada).

    // 12. Calcular a média de 2 disciplinas
    val mediaMatematica = calcularMedia(materiasENotas["Matemática"] ?: listOf())
    val mediaHistoria = calcularMedia(materiasENotas["História"] ?: listOf())

    println("Média de Matemática: $mediaMatematica")
    println("Média de História: $mediaHistoria")

    // 13. Alterar o mostrarNotas() para mostrar também a média (já foi alterado).

    // 14. Mostrar as notas de 1 disciplina
    mostrarNotas("Geografia")
}
