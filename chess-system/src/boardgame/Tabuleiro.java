package boardgame;

public class Tabuleiro {

    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1) {
            throw new BoardException("Erro criando tabuleiro: É necessário pelo menos uma linha e uma coluna ");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna) {
        if (!posicaoExiste(linha, coluna)) {
            throw new BoardException("Posição não existe no tabuleiro ");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new BoardException("Posição não existe no tabuleiro ");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void colocarPeca(Peca peca, Posicao posicao) {
        if (temUmaPeca(posicao)) {
            throw new BoardException("já há uma peça na posição " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public boolean posicaoExiste(int linha, int coluna) {
        return linha >= 0 && linha < linhas && colunas >= 0 && coluna < colunas;
    }

    public boolean posicaoExiste(Posicao posicao) {
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }

    public boolean temUmaPeca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new BoardException("Posição não existe no tabuleiro ");
        }
        return peca(posicao) != null;
    }

    public Peca removerPeca(Posicao posicao) {
        if (!posicaoExiste(posicao)) {
            throw new BoardException("Posição não existe. ");
        }
        if (peca(posicao) == null) {
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao = null;
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        return aux;
    }
}
