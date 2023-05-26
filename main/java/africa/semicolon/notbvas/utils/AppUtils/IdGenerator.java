package africa.semicolon.notbvas.utils.AppUtils;

import java.util.Random;

public enum IdGenerator {
	A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, W, X, Y, Z;
	
	private static final Random randomLetter = new Random();
	
	public static String getCharacter(){
		String letters = "";
		IdGenerator letterCharacter1 = IdGenerator.values()[randomLetter.nextInt(IdGenerator.values().length)];
		IdGenerator letterCharacter2 = IdGenerator.values()[randomLetter.nextInt(IdGenerator.values().length)];
		IdGenerator letterCharacter3 = IdGenerator.values()[randomLetter.nextInt(IdGenerator.values().length)];
		IdGenerator letterCharacter4 = IdGenerator.values()[randomLetter.nextInt(IdGenerator.values().length)];
		letters+=letterCharacter1;
		letters+=letterCharacter2;
		letters+=letterCharacter3;
		letters+=letterCharacter4;
		return letters;
	}
}
