/**
 * Вариант 2 -- шифрация
Шифрация (-c) или дешифрация (-d) указанного (в аргументе командной строки)
файла. Выходной файл указывается как -o filename.txt, по умолчанию имя
формируется из имени входного файла с добавлением расширения.
Алгоритм шифрации XOR. Ключ указывается после -c или -d в шестнадцатеричной
системе, длина ключа -- любое целое количество байт.
Кроме самой программы, следует написать автоматические тесты к ней.
 */
import java.io.File
import java.io.FileNotFoundException
import java.math.BigInteger



fun main(args: Array<String>) {
    Launcher().launch(args)
}

fun keyXOR(cKey: String, dKey: String): Int {
    var key = ""
    if (((cKey == "") && (dKey == "")) || ((cKey != "") && (dKey != ""))) return 0
    key += if (cKey != "") cKey
    else dKey
    println (BigInteger(key, 16).toInt())
    return BigInteger(key, 16).toInt()
}

fun packXOR(key: Int, inputFileName: String, outputFileName: String) {
    val file = File(outputFileName)
    val fileExists = file.exists()
    if (!(fileExists)) {
        file.createNewFile()
    }
    val writer = File(outputFileName).bufferedWriter()
    try {
        for (line in File(inputFileName).readLines()) {
            var cryptLine = ""
            for (i in line.indices) {
                cryptLine += (line[i].code.xor(key)).toChar()
            }
            writer.write(cryptLine)
            writer.newLine()
        }
    } catch (e: FileNotFoundException) {
        println("The input file does not exist")
    }
    writer.close()
}
