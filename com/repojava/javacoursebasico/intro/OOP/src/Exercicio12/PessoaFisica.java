package Exercicio12;

public class PessoaFisica extends Contribuente{
    private double rendaBruta;

    public PessoaFisica(String nome, double rendaBruta) {
        super(nome);
        this.rendaBruta = rendaBruta;
    }

    public double getRendaBruta() {
        return rendaBruta;
    }

    public void setRendaBruta(double rendaBruta) {
        this.rendaBruta = rendaBruta;
    }

    public double calcularImposto() {
        if (rendaBruta >= 1400.01 && rendaBruta <= 2100) {
            return rendaBruta * 0.10;
        }
        else if (rendaBruta >= 2100.01 && rendaBruta <= 2800) {
            return rendaBruta * 0.15;
        }
        else if (rendaBruta >= 2800.01 && rendaBruta <= 3600) {
            return rendaBruta * 0.25;
        }
        else if (rendaBruta >= 3600.01) {
            return rendaBruta * 0.30;
        }

        return 0;
    }
}
