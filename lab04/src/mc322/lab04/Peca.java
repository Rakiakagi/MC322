package mc322.lab04;

public class Peca {
    Peca cima = null,
         baixo = null,
         esquerda = null,
         direita = null;
    char P;
    
    public void pecaCima(Peca pc) {
        cima = pc;
    }
    public void pecaBaixo(Peca pc) {
        baixo = pc;
    }
    public void pecaEsquerda(Peca pc) {
        esquerda = pc;
    }
    public void pecaDireita(Peca pc) {
        direita = pc;
    }

    public void pecaComida(Peca pc) {
        P = '-';
    } 
}