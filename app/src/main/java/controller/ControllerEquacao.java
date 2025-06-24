package controller;

public class ControllerEquacao {
    //2. Criar um projeto Android em Linguagem Java com uma Activity que permita ao usuário entrar
    //com 3 números decimais (positivos e negativos), sendo a, b e c de uma equação de 2º. Grau. A
    //activity deve ter um botão que permita apresentar o valor de delta, x1 e x2 em TextViews. Deve
    //haver um TextView que permita exibir o caso de não ser equação de 2º. Grau ou não ter raízes
    //reais. Os cálculos da Equação devem estar em uma classe de controle. O app deve ter
    //possibilidade de textos em inglês e português (Além do Default).

    public double Delta(double NumA, double NumB, double NumC) {
        return (NumB * NumB) - (4 * NumA * NumC);
    }

    public double x1(double NumA, double NumB, double NumC) {
        double d = Delta(NumA, NumB, NumC);
        if (NumA == 0 || d < 0) {
            return 0;
        }
        else {
            return (-NumB + Math.sqrt(d)) / (2 * NumA);
        }
    }

    public double x2(double NumA, double NumB, double NumC) {
        double d = Delta(NumA, NumB, NumC);
        if (NumA == 0 || d < 0) {
            return 0;
        }
        else {
            return (-NumB - Math.sqrt(d)) / (2 * NumA);
        }
    }
}
