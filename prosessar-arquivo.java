import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessadorArquivo {

    public void processarArquivo(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String tipoLinha = linha.substring(0, 2);
                
                switch (tipoLinha) {
            case "00":
                Header header = new Header(linha);
                System.out.println(header);
                break;

            case "01":
                DetalhesConta detalhesConta = new DetalhesConta(linha);
                System.out.println(detalhesConta);
                break;

            case "02":
                OperacaoCreditoRotativoCompra operacaoCreditoRotativoCompra = new OperacaoCreditoRotativoCompra(linha);
                System.out.println(operacaoCreditoRotativoCompra);
                break;

            case "03":
                OperacaoCreditoRotativoSaque operacaoCreditoRotativoSaque = new OperacaoCreditoRotativoSaque(linha);
                System.out.println(operacaoCreditoRotativoSaque);
                break;

            case "04":
                ParcelamentoFatura parcelamentoFatura = new ParcelamentoFatura(linha);
                System.out.println(parcelamentoFatura);
                break;

            case "05":
                ParcelamentoAutomatico parcelamentoAutomatico = new ParcelamentoAutomatico(linha);
                System.out.println(parcelamentoAutomatico);
                break;

            case "06":
                ContratoParcTipo04e14 contratoParcTipo04e14 = new ContratoParcTipo04e14(linha);
                System.out.println(contratoParcTipo04e14);
                break;

            case "07":
                ContratoParcFormatadoPP contratoParcFormatadoPP = new ContratoParcFormatadoPP(linha);
                System.out.println(contratoParcFormatadoPP);
                break;

            case "08":
                TaxasRotativo taxasRotativo = new TaxasRotativo(linha);
                System.out.println(taxasRotativo);
                break;

            case "99":
                Trailer trailer = new Trailer(linha);
                System.out.println(trailer);
                break;

            default:
                System.out.println("Tipo de linha desconhecido: " + tipoLinha);
                break;
        }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProcessadorArquivo processador = new ProcessadorArquivo();
        processador.processarArquivo("caminho/para/o/arquivo.txt");
    }
}



public class Header {
    private String corp;
    private String dataLote;
    private String sequenciaLote;
    private String nomeArquivo;

    public Header(String linha) {
        this.corp = linha.substring(0, 3);
        this.dataLote = linha.substring(3, 11);
        this.sequenciaLote = linha.substring(11, 17);
        this.nomeArquivo = linha.substring(17, 47);
    }

    @Override
    public String toString() {
        return "Header{" +
                "corp='" + corp + '\'' +
                ", dataLote='" + dataLote + '\'' +
                ", sequenciaLote='" + sequenciaLote + '\'' +
                ", nomeArquivo='" + nomeArquivo + '\'' +
                '}';
    }
}

public class DetalhesConta {
    // Defina os campos conforme o layout
    private String codigo;
    private String numeroConta;
    // ... demais campos com base na especificação

    public DetalhesConta(String linha) {
        this.codigo = linha.substring(0, 3);
        this.numeroConta = linha.substring(3, 8);
        // ... faça o parsing dos outros campos conforme o layout
    }

    @Override
    public String toString() {
        return "DetalhesConta{" +
                "codigo='" + codigo + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}

public class OperacaoCreditoRotativoSaque {
    private String codigo;
    private String numeroConta;
    // Defina os campos conforme o layout específico da linha 03

    public OperacaoCreditoRotativoSaque(String linha) {
        this.codigo = linha.substring(0, 3);
        this.numeroConta = linha.substring(3, 8);
        // Extraia os demais campos da linha
    }

    @Override
    public String toString() {
        return "OperacaoCreditoRotativoSaque{" +
                "codigo='" + codigo + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}
public class OperacaoCreditoRotativoSaque {
    private String codigo;
    private String numeroConta;
    // Defina os campos conforme o layout específico da linha 03

    public OperacaoCreditoRotativoSaque(String linha) {
        this.codigo = linha.substring(0, 3);
        this.numeroConta = linha.substring(3, 8);
        // Extraia os demais campos da linha
    }

    @Override
    public String toString() {
        return "OperacaoCreditoRotativoSaque{" +
                "codigo='" + codigo + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}
public class ParcelamentoFatura {
    private String codigo;
    private String numeroConta;
    // Defina os campos conforme o layout específico da linha 04

    public ParcelamentoFatura(String linha) {
        this.codigo = linha.substring(0, 3);
        this.numeroConta = linha.substring(3, 8);
        // Extraia os demais campos da linha
    }

    @Override
    public String toString() {
        return "ParcelamentoFatura{" +
                "codigo='" + codigo + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}
public class ParcelamentoAutomatico {
    private String codigo;
    private String numeroConta;
    // Defina os campos conforme o layout específico da linha 05

    public ParcelamentoAutomatico(String linha) {
        this.codigo = linha.substring(0, 3);
        this.numeroConta = linha.substring(3, 8);
        // Extraia os demais campos da linha
    }

    @Override
    public String toString() {
        return "ParcelamentoAutomatico{" +
                "codigo='" + codigo + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}

public class ContratoParcTipo04e14 {
    private String codigo;
    private String numeroConta;
    // Defina os campos conforme o layout específico da linha 06

    public ContratoParcTipo04e14(String linha) {
        this.codigo = linha.substring(0, 3);
        this.numeroConta = linha.substring(3, 8);
        // Extraia os demais campos da linha
    }

    @Override
    public String toString() {
        return "ContratoParcTipo04e14{" +
                "codigo='" + codigo + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}
public class ContratoParcFormatadoPP {
    private String codigo;
    private String numeroConta;
    // Defina os campos conforme o layout específico da linha 07

    public ContratoParcFormatadoPP(String linha) {
        this.codigo = linha.substring(0, 3);
        this.numeroConta = linha.substring(3, 8);
        // Extraia os demais campos da linha
    }

    @Override
    public String toString() {
        return "ContratoParcFormatadoPP{" +
                "codigo='" + codigo + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}
public class TaxasRotativo {
    private String codigo;
    private String numeroConta;
    // Defina os campos conforme o layout específico da linha 08

    public TaxasRotativo(String linha) {
        this.codigo = linha.substring(0, 3);
        this.numeroConta = linha.substring(3, 8);
        // Extraia os demais campos da linha
    }

    @Override
    public String toString() {
        return "TaxasRotativo{" +
                "codigo='" + codigo + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                '}';
    }
}
public class Trailer {
    private String codigo;
    private String quantidadeRegistros;
    // Defina os campos conforme o layout específico da linha 99

    public Trailer(String linha) {
        this.codigo = linha.substring(0, 3);
        this.quantidadeRegistros = linha.substring(3, 10);
        // Extraia os demais campos da linha
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "codigo='" + codigo + '\'' +
                ", quantidadeRegistros='" + quantidadeRegistros + '\'' +
                '}';
    }
}

