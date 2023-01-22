package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.PartidaDeXadrez;
import chess.PecaDeXadrez;
import chess.PosicaoDoXadrez;

public class Programa {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();

        while (true) {
            try {
                UI.limparTela();
                UI.imprimeTabuleiro(partidaDeXadrez.pegarPecas());
                System.out.println();
                System.out.print("Origem: ");
                PosicaoDoXadrez origem = UI.lerPosicaoDoXadrez(sc);

                System.out.println();
                System.out.print("Destino: ");
                PosicaoDoXadrez destino = UI.lerPosicaoDoXadrez(sc);

                PecaDeXadrez pecaCapturada = partidaDeXadrez.executarJogada(origem, destino);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}
