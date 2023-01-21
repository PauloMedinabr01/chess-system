package application;

import boardgame.Tabuleiro;
import chess.PartidaDeXadrez;

public class Programa {
    public static void main(String[] args) throws Exception {

        PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();
        UI.imprimeTabuleiro(partidaDeXadrez.pegarPecas());
    }
}
