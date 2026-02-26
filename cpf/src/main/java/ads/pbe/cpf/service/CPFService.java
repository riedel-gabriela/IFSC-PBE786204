package ads.pbe.cpf.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class CPFService {
    public boolean assertValid(String cpf) {
        if (cpf == null) {
            return false;
        }

        int[] digits = extractDigits(cpf);

        if (!isValidLengthAndNotRepeated(digits)) {
            return false;
        }

        int digit1 = calculateDigit(digits, 10);
        int digit2 = calculateDigit(digits, 11);

        return digit1 == digits[9] && digit2 == digits[10];
    }

    private int[] extractDigits(String cpf) {
        return cpf.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .toArray();
    }

    private boolean isValidLengthAndNotRepeated(int[] digits) {
        return digits.length == 11 && Arrays.stream(digits).distinct().count() > 1;
    }

    private int calculateDigit(int[] digits, int factor) {
        int sum = 0;
        for (int i = 0; i < factor - 1; i++) {
            sum += digits[i] * (factor - i);
        }
        int remainder = 11 - (sum % 11);
        return (remainder >= 10) ? 0 : remainder;
    }
}
