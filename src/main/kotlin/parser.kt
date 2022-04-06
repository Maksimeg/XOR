import org.kohsuke.args4j.Argument
import org.kohsuke.args4j.CmdLineException
import org.kohsuke.args4j.CmdLineParser
import org.kohsuke.args4j.Option

class Launcher {

    @Option(name = "-c", metaVar = "Encrypt", usage = "encrypt key", forbids = ["-d"])
    private var cKey: String = ""

    @Option(name = "-d", metaVar = "Decrypt", usage = "decrypt key", forbids = ["-c"])
    private var dKey: String = ""

    @Option(name = "-o", metaVar = "OutputName", usage = "output file name")
    private var outputFileName: String = "0"

    @Argument(metaVar = "InputName", usage = "input file name")
    private var inputFileName: String = ""

    fun launch(args: Array<String>) {
        val parser = CmdLineParser(this)
        try {
            parser.parseArgument(args.toList())
        } catch (e: CmdLineException) {
            println(e.message)
        }
        val key = keyXOR(cKey, dKey)
        packXOR(key, inputFileName, outputFileName)
    }
}