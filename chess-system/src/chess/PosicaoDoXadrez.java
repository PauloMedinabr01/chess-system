package chess;

import boardgame.Posicao;

public class PosicaoDoXadrez {
    private char coluna;
    private int linha;

    public PosicaoDoXadrez(char coluna, int linha) {
        if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
            throw new ChessException("Erro ao instanciar a posição do Xadrez: Valores validos são de a1 a h8. ");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }

    protected Posicao posicionar() {
        return new Posicao(8 - linha, coluna - 'a');
    }

    protected static PosicaoDoXadrez daPosição(Posicao posicao) {
        return new PosicaoDoXadrez((char) ('a' - posicao.getColuna()), 8 - posicao.getLinha());
    }

    @Override
    public String toString() {
        return ""
                + coluna
                + linha;
    }

}