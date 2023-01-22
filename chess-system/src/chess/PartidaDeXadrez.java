package chess;

import boardgame.Peca;
import boardgame.Posicao;
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

    public PecaDeXadrez executarJogada(PosicaoDoXadrez posicaoFonte, PosicaoDoXadrez posicaoDestino) {
        Posicao fonte = posicaoFonte.posicionar();
        Posicao destino = posicaoDestino.posicionar();
        validarPosicaoAlvo(fonte);
        Peca pecaCapturada = fazerMover(fonte, destino);
        return (PecaDeXadrez) pecaCapturada;
    }

    private Peca fazerMover(Posicao fonte, Posicao destino) {
        Peca p = tabuleiro.removerPeca(fonte);
        Peca pecaCapturada = tabuleiro.removerPeca(destino);
        tabuleiro.colocarPeca(p, destino);
        return pecaCapturada;
    }

    private void validarPosicaoAlvo(Posicao posicao) {
        if (!tabuleiro.temUmaPeca(posicao)) {
            throw new ChessException("Não há nenhuma peça na posição de origem");
        }
    }

    private void colocarNovaPeça(char coluna, int linha, PecaDeXadrez peca) {
        tabuleiro.colocarPeca(peca, new PosicaoDoXadrez(coluna, linha).posicionar());
    }

    private void setupInicial() {
        colocarNovaPeça('c', 1, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeça('c', 2, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeça('d', 2, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeça('e', 2, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeça('e', 1, new Torre(tabuleiro, Cor.WHITE));
        colocarNovaPeça('d', 1, new Rei(tabuleiro, Cor.WHITE));

        colocarNovaPeça('c', 7, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeça('c', 8, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeça('d', 7, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeça('e', 7, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeça('e', 8, new Torre(tabuleiro, Cor.BLACK));
        colocarNovaPeça('d', 8, new Rei(tabuleiro, Cor.BLACK));
    }
}
