package cardsPackage;

public class InputCheck {

	protected boolean DigitsOnly(String inputLine) {
		boolean correctLine = true;
		int Dot = 0;

		// отрезаем символы с ascii кодом <= 20 в начале и в конце строки
		inputLine.trim();
		// заводим массив ascii кодов для всех символов строки
		byte[] asciiCodes = new byte[inputLine.length()];
		// заполняем
		asciiCodes = inputLine.getBytes();
		// проверяем, нет ли чего-то кроме цифр и точки
		for (int i = 0; i < inputLine.length(); i++) {
			if ((asciiCodes[i] <= 45) || (asciiCodes[i] >= 58)
					|| (asciiCodes[i] == 47)) {
				correctLine = false;
			} else if (asciiCodes[i] == 46) {
				Dot++;
			}
		}
		if (Dot > 1) {
			correctLine = false;
		}
		return correctLine;
	}
}