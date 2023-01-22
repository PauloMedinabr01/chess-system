package chess;

import boardgame.Tabuleiro;
import chess.pieces.Rei;
import chess.pieces.Torre;

public class PartidaDeXadrez {

    private Tabuleiro tabuleiro;

    public PartidaDeXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        setupInicial();
    }

    public PecaDeXadrez[][] pegarPecas() {
        PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    private void colocarNovaPeça(char coluna, int linha, PecaDeXadrez peca) {
        tabuleiro.colocarPeca(peca, new posiçãoDoXadrez(coluna, linha).posicionar());
    }

    private void setupInicial() {
        colocarNovaPeça('b', 6, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeça('c', 4, new Rei(tabuleiro, Cor.PRETO));
        colocarNovaPeça('d', 7, new Torre(tabuleiro, Cor.BRANCO));
    }
}
